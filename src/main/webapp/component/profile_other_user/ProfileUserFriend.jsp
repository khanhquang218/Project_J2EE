<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="list_friend">
	<div class="list_friend-list_header">
		<p class="list_friend-list_title">Bạn bè</p>
		<div>
			<a href="/Project_J2EE/RecommendFriend.jsp">Tìm kiếm bạn bè</a>
			<a href="/Project_J2EE/FriendRequest.jsp">Lời mời kết bạn</a>
		</div>
	</div>
	<div id="list_friend-list_member" class="list_friend-list_member">
		<!-- 				<div class="list_friend-info_member"> -->
		<!-- 					<div class="list_friend-img_member"> -->
		<!-- 						<img -->
		<!-- 							src="https://afamilycdn.com/k:PAnfQNsxF6z1mYzwDP5Q7dH6RhofJn/Image/2015/01/chauhaimyloanhxauxi/soc-voi-anh-xau-xi-cua-duong-thuc-phi-trong-vo-tac-thien.jpg" -->
		<!-- 							alt="" /> -->
		<!-- 					</div> -->
		<!-- 					<div class="list_friend-name_member"> -->
		<!-- 						<p class="list_friend-name_child">Danh Vo</p> -->
		<!-- 						<p class="list_friend-friend_child">300 bạn chung</p> -->
		<!-- 					</div> -->
		<!-- 					<div id="list_friend-action_icon" class="list_friend-action_icon"> -->
		<!-- 						<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" -->
		<!-- 							viewBox="0 0 23 23" fill="none"> -->
		<!-- 			              <path -->
		<!-- 								d="M0.410767 11.5C0.410767 10.8328 0.713667 10.193 1.25283 9.72118C1.792 9.24941 2.52327 8.98438 3.28577 8.98438C4.04826 8.98438 4.77953 9.24941 5.3187 9.72118C5.85787 10.193 6.16077 10.8328 6.16077 11.5C6.16077 12.1672 5.85787 12.807 5.3187 13.2788C4.77953 13.7506 4.04826 14.0156 3.28577 14.0156C2.52327 14.0156 1.792 13.7506 1.25283 13.2788C0.713667 12.807 0.410767 12.1672 0.410767 11.5ZM8.62505 11.5C8.62505 10.8328 8.92795 10.193 9.46712 9.72118C10.0063 9.24941 10.7376 8.98438 11.5001 8.98438C12.2626 8.98438 12.9938 9.24941 13.533 9.72118C14.0722 10.193 14.3751 10.8328 14.3751 11.5C14.3751 12.1672 14.0722 12.807 13.533 13.2788C12.9938 13.7506 12.2626 14.0156 11.5001 14.0156C10.7376 14.0156 10.0063 13.7506 9.46712 13.2788C8.92795 12.807 8.62505 12.1672 8.62505 11.5ZM19.7143 8.98438C20.4768 8.98438 21.2081 9.24941 21.7473 9.72118C22.2864 10.193 22.5893 10.8328 22.5893 11.5C22.5893 12.1672 22.2864 12.807 21.7473 13.2788C21.2081 13.7506 20.4768 14.0156 19.7143 14.0156C18.9518 14.0156 18.2206 13.7506 17.6814 13.2788C17.1422 12.807 16.8393 12.1672 16.8393 11.5C16.8393 10.8328 17.1422 10.193 17.6814 9.72118C18.2206 9.24941 18.9518 8.98438 19.7143 8.98438Z" -->
		<!-- 								fill="black" /> -->
		<!-- 			            </svg> -->
		<!-- 					</div> -->
		<!-- 					<div class="list_friend-box_show_action"> -->
		<!-- 						<div class="list_friend-child"> -->
		<!-- 							<svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" -->
		<!-- 								viewBox="0 0 21 21" fill="none"> -->
		<!-- 				                <path -->
		<!-- 									d="M3 1.3125C1.34531 1.3125 0 2.48965 0 3.9375V17.0625C0 18.5104 1.34531 19.6875 3 19.6875H18C19.6547 19.6875 21 18.5104 21 17.0625V3.9375C21 2.48965 19.6547 1.3125 18 1.3125H3ZM9.375 14.1094V11.4844H6.375C5.75156 11.4844 5.25 11.0455 5.25 10.5C5.25 9.95449 5.75156 9.51562 6.375 9.51562H9.375V6.89062C9.375 6.34512 9.87656 5.90625 10.5 5.90625C11.1234 5.90625 11.625 6.34512 11.625 6.89062V9.51562H14.625C15.2484 9.51562 15.75 9.95449 15.75 10.5C15.75 11.0455 15.2484 11.4844 14.625 11.4844H11.625V14.1094C11.625 14.6549 11.1234 15.0938 10.5 15.0938C9.87656 15.0938 9.375 14.6549 9.375 14.1094Z" -->
		<!-- 									fill="black" /> -->
		<!-- 				            </svg> -->
		<!-- 							<p>Theo dõi</p> -->
		<!-- 						</div> -->
		<!-- 						<div class="list_friend-child"> -->
		<!-- 							<svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" -->
		<!-- 								viewBox="0 0 21 21" fill="none"> -->
		<!-- 				                <g clip-path="url(#clip0_156_1721)"> -->
		<!-- 				                  <path -->
		<!-- 									d="M3.15 5.25C3.15 3.85761 3.5925 2.52226 4.38015 1.53769C5.1678 0.553123 6.23609 0 7.35 0C8.46391 0 9.5322 0.553123 10.3198 1.53769C11.1075 2.52226 11.55 3.85761 11.55 5.25C11.55 6.64239 11.1075 7.97775 10.3198 8.96231C9.5322 9.94688 8.46391 10.5 7.35 10.5C6.23609 10.5 5.1678 9.94688 4.38015 8.96231C3.5925 7.97775 3.15 6.64239 3.15 5.25ZM0 19.7818C0 15.7418 2.61844 12.4688 5.85047 12.4688H8.84953C12.0816 12.4688 14.7 15.7418 14.7 19.7818C14.7 20.4545 14.2636 21 13.7255 21H0.974531C0.436406 21 0 20.4545 0 19.7818ZM15.4547 5.86523C15.7631 5.47969 16.2619 5.47969 16.567 5.86523L18.1092 7.79297L19.6514 5.86523C19.9598 5.47969 20.4586 5.47969 20.7637 5.86523C21.0689 6.25078 21.0722 6.87422 20.7637 7.25566L19.2216 9.1834L20.7637 11.1111C21.0722 11.4967 21.0722 12.1201 20.7637 12.5016C20.4553 12.883 19.9566 12.8871 19.6514 12.5016L18.1092 10.5738L16.567 12.5016C16.2586 12.8871 15.7598 12.8871 15.4547 12.5016C15.1495 12.116 15.1462 11.4926 15.4547 11.1111L16.9969 9.1834L15.4547 7.25566C15.1462 6.87012 15.1462 6.24668 15.4547 5.86523Z" -->
		<!-- 									fill="black" /> -->
		<!-- 				                </g> -->
		<!-- 				                <defs> -->
		<!-- 				                  <clipPath id="clip0_156_1721"> -->
		<!-- 				                    <rect width="21" height="21" fill="white" /> -->
		<!-- 				                  </clipPath> -->
		<!-- 				                </defs> -->
		<!-- 				             </svg> -->
		<!-- 							<p>Hủy kết bạn</p> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 				</div> -->
	</div>
</div>

<script>
	window.onload = () => {
		new RemindFriend({
			userID :
	<%=request.getParameter("id")%>
		}).render();
	}
</script>



