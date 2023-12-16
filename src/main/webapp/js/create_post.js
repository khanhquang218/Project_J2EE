class CreatePost {

	constructor() {
		this.listImg = []
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

	renderListImage() {
		const that = this;
		const resultData = (image) => {
			return `
				<div class="create_post-add_image">
					<button class="create_post-delete_image" dataimg = "${image}">
						<svg xmlns="http://www.w3.org/2000/svg" height="1em"
							viewBox="0 0 384 512">
									! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc.
									<path
								d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z" /></svg>
					</button>
					<img alt="anh"
						src="${image}">
				</div>
			`
		}

		const wrapperCreatePostAddImage = $("#create_post-list_image_inner");

		var reultListImage = "";
		if (that.listImg.length > 0) {

			reultListImage = that.listImg.map((element) => {
				return resultData(element)
			}).join("");
		}

		wrapperCreatePostAddImage.innerHTML = reultListImage || "";

		if (that.listImg.length > 0) {
			const btnDeleteImg = $$('.create_post-delete_image');

			for (let tempBtn of btnDeleteImg) {
				tempBtn.onclick = (e) => {

					console.log(tempBtn.getAttribute('dataimg'))
					that.listImg = that.listImg.filter(item => item !== tempBtn.getAttribute('dataimg'));
					that.renderListImage();
				}

				if (that.listImg.length >= 4) {
					$("#create_post-add_image").style.display = "none";
				} else {
					$("#create_post-add_image").style.display = "flex";
				}
			}
		}

	}

	async render() {
		const that = this;

		const wrapperCreatePostRender = $("#showCreatePostGloabal")
		const btnClostPost = $('#create_post-btn_close');
		const btnCreatePostAddImage = $("#create_post-btn_add_img");
		const wrapperCreatePostAddImage = $(".create_post-list_image");
		const createPostUpload = $("#create_post-upload_file");
		const tabAddImage = $("#create_post-add_image")
		const txtCreatePost = $("#create_post-content_text");


		if (btnCreatePostAddImage) {
			btnCreatePostAddImage.onclick = () => {
				if (!wrapperCreatePostAddImage.classList.contains("create_post-list_image_show")) {
					wrapperCreatePostAddImage.classList.add("create_post-list_image_show")
					createPostUpload.click();
				}
			}
		}

		if (tabAddImage)
			tabAddImage.onclick = () => {
				createPostUpload.click();
			}

		function preview_image_create_post(event) {
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
					var dataUrl = canvas.toDataURL('image/jpeg', 0.5); // Điều chỉnh chất lượng ở đây

					that.listImg.push(dataUrl);
					that.renderListImage();

					if (that.listImg.length >= 4) {
						$("#create_post-add_image").style.display = "none";
					}
				};
				img.src = e.target.result;
			}
			reader.readAsDataURL(event.target.files[0]);
		}


		if (createPostUpload)
			createPostUpload.onchange = (e) => {
				preview_image_create_post(e);
			}

		const handleShowCreatePostDetail = () => {
			wrapperCreatePostRender.style.display = "block";

			txtCreatePost.focus();

			that.renderListImage();

		}

		if (btnClostPost)
			btnClostPost.onclick = () => {
				wrapperCreatePostRender.style.display = "none";
			}

		if ($("#create_post-content_before"))
			$("#create_post-content_before").onclick = () => {
				handleShowCreatePostDetail();
			}

		if ($("#create_post-profile-select_before"))
			$("#create_post-profile-select_before").onclick = () => {
				handleShowCreatePostDetail();
			}


		const btnCreatePostInSidebarLeft = $(".sidebar_left-create-post-button");

		if (btnCreatePostInSidebarLeft)
			btnCreatePostInSidebarLeft.onclick = () => {
				handleShowCreatePostDetail();
			}

		const btnSubmitCreatePost = $("#create_post-submit-btn_after");

		var wsUrl;
		if (window.location.protocol == 'http:') {
			wsUrl = 'ws://';
		} else {
			wsUrl = 'wss://';
		}
		var ws = new WebSocket(wsUrl + window.location.host + "/Project_J2EE/notify");

		if (btnSubmitCreatePost) {

			const handleSendNotification = async (refID = -1) => {
				const url = "/Project_J2EE/api/notification/create_post_notifiation";
				const send_data = {
					refID,
					rootID: getCookieGlobal("id"),
					userID: getCookieGlobal("id"),
					firstName: getCookieGlobal("firstName"),
					lastName: getCookieGlobal("lastName"),
					title: "Thêm bài viết mới"
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


			btnSubmitCreatePost.onclick = () => {
				const url = "/Project_J2EE/api/post/create_post";
				const send_data = {
					content: txtCreatePost.innerHTML || "",
					image1: that.listImg[0] || "",
					image2: that.listImg[1] || "",
					image3: that.listImg[2] || "",
					image4: that.listImg[3] || "",
					authorID: getCookieGlobal("id") || "-1",
					privacySettingID: "10",
				};

				const xhr = new XMLHttpRequest();
				xhr.open("POST", url, true);
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.setRequestHeader("Authorization", `${that.getCookieGlobalPlus("token")}`);

				xhr.onreadystatechange = async function() {
					if (xhr.readyState === 4) {
						if (xhr.status === 200) {
							try {
								const data = JSON.parse(JSON.parse(xhr.responseText));
								showMessageGlobal("Tạo bài viết thành công!")
								wrapperCreatePostRender.style.display = "none";
								txtCreatePost.innerHTML = "";

								await handleSendNotification(data.refID).then((result) => {
									ws.send(JSON.stringify(result));

									window.location.reload();
								});

							} catch (error) {
								console.log("JSON parsing error:", error);
							}
						} else {
							console.log("Request failed with status:", xhr.status);
						}
					}
				}
				xhr.send(JSON.stringify(send_data));

			}
		}


	}
}

const fncRenderCreatePost = async () => {
	const createPost = await new CreatePost().render();

}

fncRenderCreatePost();
