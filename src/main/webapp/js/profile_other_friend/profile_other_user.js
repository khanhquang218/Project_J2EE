class ProfileOtherUser {
	constructor(data = { id: "" }) {
		this.data = data;
		this.idSendRequest = false;
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

		const btnAddFriend = $("#btnAddFriendInProfile");

		var wsUrl;
		if (window.location.protocol == 'http:') {
			wsUrl = 'ws://';
		} else {
			wsUrl = 'wss://';
		}
		var ws = new WebSocket(wsUrl + window.location.host + "/Project_J2EE/notify");

		const handleSendNotification = async () => {
			const url = "/Project_J2EE/api/notification/send_friend_request";
			const send_data = {
				refID: -1,
				rootID: getCookieGlobal("id"),
				userID: that.data.id,
				firstName: getCookieGlobal("firstName"),
				lastName: getCookieGlobal("lastName"),
				title: "Yêu cầu kết bạn"
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

								ws.send(JSON.stringify([that.data.id]))

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


		if (btnAddFriend) {
			const handleAddFriendRequest = async () => {
				const url = "/Project_J2EE/api/friend_request/add_friend_request";
				const send_data = {
					requestID: that.data.id,
					userID: getCookieGlobal("id")
				};

				return new Promise((resolve, reject) => {
					const xhr = new XMLHttpRequest();
					xhr.open("POST", url, true);

					xhr.setRequestHeader("Content-Type", "application/json");
					xhr.setRequestHeader("Authorization", `${that.getCookieGlobalPlus("token")}`);

					xhr.onreadystatechange = async function() {
						if (xhr.readyState === 4) {
							if (xhr.status === 200) {
								try {
									const data = JSON.parse(xhr.responseText);
									this.idSendRequest = true;
									await handleSendNotification();

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

			btnAddFriend.onclick = () => {
				if (!that.idSendRequest) {
					handleAddFriendRequest().then(() => {
						window.location.reload();
					});
				}
			}
		}

		const btnCancleAddFriend = $("#btnCancleFriendReuestProfile");

		const handleDenyFriendRequest = async () => {
			const url = "/Project_J2EE/api/friend_request/deny_add_friend_request";
			const send_data = {
				requestID: getCookieGlobal("id"),
				userID: that.data.id,
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
								console.log(data)

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

		if (btnCancleAddFriend) {
			btnCancleAddFriend.onclick = () => {
				if (!that.idSendRequest) {
					handleDenyFriendRequest().then(() => {

						btnCancleAddFriend.innerHTML = "<p>Đã từ chuối yêu cầu</p>"
						window.location.reload();
					});
				}
			}
		}


		const btnAcceptFriendRequest = $("#btnAcceptFriendReuestProfile");

		if (btnAcceptFriendRequest) {
			const handleAcceptFriendRequest = async () => {
				const url = "/Project_J2EE/api/friend_request/accept_friend_request";
				const send_data = {
					friendRequestID: that.data.id,
					requestID: getCookieGlobal("id"),
					userID: that.data.id,
				};

				return new Promise((resolve, reject) => {
					const xhr = new XMLHttpRequest();
					xhr.open("POST", url, true);

					xhr.setRequestHeader("Content-Type", "application/json");
					xhr.setRequestHeader("Authorization", `${that.getCookieGlobalPlus("token")}`);

					xhr.onreadystatechange = async function() {
						if (xhr.readyState === 4) {
							if (xhr.status === 200) {
								try {
									const data = JSON.parse(xhr.responseText);

									var wsUrl;
									if (window.location.protocol == 'http:') {
										wsUrl = 'ws://';
									} else {
										wsUrl = 'wss://';
									}
									var ws = new WebSocket(wsUrl + window.location.host + "/Project_J2EE/notify");

									const handleSendNotificationAccept = async () => {
										const url = "/Project_J2EE/api/notification/accept_friend";
										const send_data = {
											refID: -1,
											rootID: getCookieGlobal("id"),
											userID: that.data.id,
											firstName: getCookieGlobal("firstName"),
											lastName: getCookieGlobal("lastName"),
											title: "Đồng ý kết bạn"
										};

										console.log(send_data)
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

															ws.send(JSON.stringify([that.data.id]))

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

									await handleSendNotificationAccept();


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

			btnAcceptFriendRequest.onclick = () => {
				handleAcceptFriendRequest().then(() => {
					window.location.reload();
				})
			}

		}

		const btnFriendProfile = $("#btnFriendUserProfile");
		if (btnFriendProfile) {

			const btnUnfriend = $("#btnUnfriendProfile");

			const handleUnfriend = async () => {
				const url = "/Project_J2EE/api/friend/unfriend";
				const send_data = {
					friendID: getCookieGlobal("id"),
					userID: that.data.id,
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
									console.log(data)

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

			btnUnfriend.onclick = () => {
				handleUnfriend().then(() => {
					window.location.reload();
				})
			}



			btnFriendProfile.onclick = () => {
				if (!$(".profile_user-dropdown-menu").classList.contains("profile_user-dropdown-menu_show")) {
					$(".profile_user-dropdown-menu").classList.add("profile_user-dropdown-menu_show")
				} else {
					$(".profile_user-dropdown-menu").classList.remove("profile_user-dropdown-menu_show")
				}
			}
		}


		const btnFollow = $("#btnProfileUserFollow");

		if (btnFollow) {

			const handleFollow = async () => {
				const url = "/Project_J2EE/api/follow/add_follow";
				const send_data = {
					userID: getCookieGlobal("id"),
					followID: that.data.id,
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
									console.log(data)

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

			btnFollow.onclick = () => {
				handleFollow().then(() => {
					window.location.reload();
				})
			}
		}

		const wrapperUnfollow = $("#wrapperBtnUnfollowProfile");

		if (wrapperUnfollow) {

			wrapperUnfollow.onclick = () => {
				wrapperUnfollow.classList.toggle("global_post-status_profile_show_unfollow")
			}

			const btnUnfollow = $("#btnUnfollowProfile");

			const handleUnfollow = async () => {
				const url = "/Project_J2EE/api/follow/unfollow";
				const send_data = {
					userID: getCookieGlobal("id"),
					followID: that.data.id,
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
									console.log(data)

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

			btnUnfollow.onclick = () => {
				handleUnfollow().then(() => {
					window.location.reload();
				})
			}
		}


	}
}

//new ProfileOtherUser().render();