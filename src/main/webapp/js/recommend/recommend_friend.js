class RecommendFriend {
	constructor() {
		this.listRecommend = []
		this.currendPage = 0
		this.LENGTHPAGE = 10
	}

	decryptCookieValuePlus(encodedValue, encryptionKey) {
		try {
			// Decode the Base64 encoded value
			var encryptedValue = CryptoJS.enc.Base64.parse(encodedValue);

			// Create a key object from the encryption key
			var key = CryptoJS.enc.Utf8.parse(encryptionKey);

			// Perform decryption using AES
			var decryptedBytes = CryptoJS.AES.decrypt({ ciphertext: encryptedValue }, key, {
				mode: CryptoJS.mode.ECB,
				padding: CryptoJS.pad.Pkcs7
			});

			// Convert the decrypted bytes to a UTF-8 string
			var decryptedValue = decryptedBytes.toString(CryptoJS.enc.Utf8);

			return decryptedValue;
		} catch (error) {
			console.error('Error decrypting cookie value:', error);
			return null;
		}
	}

	getCookieGlobalPlus(name) {
		var cookies = document.cookie.split(';');
		for (var i = 0; i < cookies.length; i++) {
			var cookie = cookies[i].trim();
			if (cookie.indexOf(name + '=') === 0) {
				var encodedValue = cookie.substring(name.length + 1, cookie.length);

				// Thực hiện giải mã với cùng một key (khóa)
				var decryptedValue = this.decryptCookieValuePlus(encodedValue, '1234567890123456');

				return decryptedValue;
			}
		}
		return null;
	}

	async fetchListRecommendFriend() {
		const that = this;

		const url = "/Project_J2EE/api/user/search_recommend_friend";
		const send_data = {
			limitValue: that.LENGTHPAGE,
			offsetValue: that.LENGTHPAGE * that.currendPage,
			userID: getCookieGlobal("id")
		};

		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			xhr.open("POST", url, true);

			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Authorization", `${that.getCookieGlobalPlus("token")}`);

			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						try {
							const data = JSON.parse(xhr.responseText);
							that.listRecommend = data;
							that.currendPage += 1;
							resolve(data);
						} catch (error) {
							console.log("JSON parsing error:", error);
							reject(error);
						}
					} else {
						console.log("Request failed with status:", xhr.status);
						reject(new Error(`Error: ${xhr.statusText}`));
					}
				}
			}.bind(this);

			xhr.send(JSON.stringify(send_data));
		});
	}

	async renderListRecommend() {
		const that = this;

		const renderListRecommend = await Promise.all(that.listRecommend.map(async (element) => {
			const recommendData = {
				image: element.image,
				name: element.firstName + " " + element.lastName,
				id: element.id,
				countRoomate: element.countRoomate,
			};

			const userRecommendItem = new RecommendFriendItem(recommendData);
			const result = userRecommendItem.render();

			return result;
		}));


		return renderListRecommend.join("");
	}

	async render() {
		const that = this;

		const wrapperListRender = $("#wrapperRenderListRecommnendFriend");
		await this.fetchListRecommendFriend();

		await that.renderListRecommend().then((resultRender) => {

			if (wrapperListRender && resultRender) {
				wrapperListRender.innerHTML = resultRender;
			} else {
				wrapperListRender.innerHTML = `<div style="margin-left: 0;opacity: 0.6">Không có gợi ý nào.</div>`;
			}
		});

	}
}

new RecommendFriend().render()