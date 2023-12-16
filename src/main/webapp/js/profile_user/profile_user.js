class ProfileUser {
	constructor() {

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

	render() {
		const that = this;
		setTimeout(() => {
			const wrapperUpdateBox = $("#profile_user_modal_box");
			const btnUpdateProfile = $("#profile_user-tabs-update_profile");
			const btnCloseUpdateProfile = $("#btnCloseUpdateProfile")

			if (btnUpdateProfile)
				btnUpdateProfile.onclick = () => {
					wrapperUpdateBox.classList.add("profile_user_modal_box_show")
				}
			if (btnCloseUpdateProfile)
				btnCloseUpdateProfile.onclick = () => {
					if (wrapperUpdateBox.classList.contains("profile_user_modal_box_show")) {
						wrapperUpdateBox.classList.remove("profile_user_modal_box_show")
					}
				}
		})

		const backgroundUpload = $("#profile_user-background_file");
		const avataUpload = $("#profile_user-avata_file");
		const backgroundImage = $("#profile_user-img_background");
		const avataImage = $("#profile_user-img_avata");

		const btnUpdateBackground = $("#profile_user-tabs-update_picture_background");
		const btnUpdateAvata = $("#profile_user-tabs-update_picture_avata");

		btnUpdateBackground.onclick = () => {
			backgroundUpload.click();
		}

		btnUpdateAvata.onclick = () => {
			avataUpload.click();
		}

		backgroundUpload.onchange = (e) => {
			profile_image_background(e);
		}

		avataUpload.onchange = (e) => {
			profile_image_avata(e);
		}

		const handleUpdateBackground = async (userID, background) => {
			const url = "/Project_J2EE/api/user/update_background";
			const send_data = {
				userID,
				background,
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


		function profile_image_background(event) {
			var tempSrc = "";

			var reader = new FileReader();
			reader.onload = function(e) {
				var img = new Image();

				img.onload = function() {
					var canvas = document.createElement('canvas');
					var ctx = canvas.getContext('2d');

					// Set the canvas size to the desired dimensions
					canvas.width = img.width / 2; // Giảm kích thước xuống một nửa
					canvas.height = img.height / 2;

					// Điền màu trắng vào canvas trước
					ctx.fillStyle = 'white';
					ctx.fillRect(0, 0, canvas.width, canvas.height);

					// Bây giờ vẽ ảnh lên trên màu trắng
					ctx.drawImage(img, 0, 0, canvas.width, canvas.height);

					// Convert the canvas to a data URL with reduced quality
					var dataUrl = canvas.toDataURL('image/jpeg', 0.4); // Điều chỉnh chất lượng ở đây

					tempSrc = backgroundImage.src;

					backgroundImage.src = dataUrl;

					setTimeout(() => {
						if (confirm("Bạn có muốn lưu thay đổi không?") == true) {
							handleUpdateBackground(getCookieGlobal("id"), dataUrl).then(() => {
								localStorage.setItem('background', JSON.stringify((dataUrl)));
							})
						} else {
							backgroundImage.src = tempSrc;
						}
					}, 100)

				};

				img.src = e.target.result;
			}
			reader.readAsDataURL(event.target.files[0]);
		}

		const handleUpdateAvata = async (userID, avata) => {
			const url = "/Project_J2EE/api/user/update_avata";
			const send_data = {
				userID,
				avata,
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

		function profile_image_avata(event) {
			var tempSrc = "";

			var reader = new FileReader();
			reader.onload = function(e) {
				var img = new Image();
				img.onload = function() {
					var canvas = document.createElement('canvas');
					var ctx = canvas.getContext('2d');

					// Set the canvas size to the desired dimensions
					canvas.width = img.width / 3; // Giảm kích thước xuống một nửa
					canvas.height = img.height / 3;

					// Điền màu trắng vào canvas trước
					ctx.fillStyle = 'white';
					ctx.fillRect(0, 0, canvas.width, canvas.height);

					// Bây giờ vẽ ảnh lên trên màu trắng
					ctx.drawImage(img, 0, 0, canvas.width, canvas.height);

					// Convert the canvas to a data URL with reduced quality
					var dataUrl = canvas.toDataURL('image/jpeg', 0.2); // Điều chỉnh chất lượng ở đây

					tempSrc = avataImage.src;

					avataImage.src = dataUrl;

					setTimeout(() => {
						if (confirm("Bạn có muốn lưu thay đổi không?") == true) {

							handleUpdateAvata(getCookieGlobal("id"), dataUrl).then(() => {
								localStorage.setItem('image', JSON.stringify((dataUrl)));
							})

						} else {
							avataImage.src = tempSrc;

						}
					}, 10)

				};
				img.src = e.target.result;
			}
			reader.readAsDataURL(event.target.files[0]);
		}
	}
}

new ProfileUser().render();