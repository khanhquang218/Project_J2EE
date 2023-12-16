<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String paramName = "value"; // Thay đổi thành tên tham số bạn quan tâm
String paramValue = request.getParameter(paramName);
%>

<div id="sidebar-left"
	style="width: 356px; position: fixed; margin-top: var(--height-default-header); top: 0;">
	<div class="sidebar_left-wrapper">
		<div class="sidebar_left-top">
			<div class="sidebar_left-follow-section">
				<div class="sidebar_left-follow-heading"
					style="display: flex; flex-wrap: nowrap;">
					Kết quả với từ khóa:
					<div
						style="font-weight: 400; margin-left: 3px; font-style: italic;"><%=paramValue%></div>
				</div>
			</div>
			<ul class="sidebar_left-menu">
				<a
					href="/Project_J2EE/Search.jsp?page=all&value=<%=request.getParameter("value")%>"><li
					class='sidebar_left-menu-item <%=request.getParameter("page").equals("all") ? "sidebar_left-menu-item_active" : ""%>'><i>
							<svg width="22" height="21" viewBox="0 0 22 21" fill="none"
								xmlns="http://www.w3.org/2000/svg">
							<path
									d="M4.00849 3.3125C4.00849 1.72676 5.20686 0.4375 6.68081 0.4375H18.7063C20.1802 0.4375 21.3786 1.72676 21.3786 3.3125V17.6875C21.3786 19.2732 20.1802 20.5625 18.7063 20.5625H3.3404C1.49483 20.5625 0 18.9543 0 16.9688V4.75C0 3.95488 0.597097 3.3125 1.33616 3.3125C2.07523 3.3125 2.67232 3.95488 2.67232 4.75V16.9688C2.67232 17.3641 2.97296 17.6875 3.3404 17.6875C3.70785 17.6875 4.00849 17.3641 4.00849 16.9688V3.3125ZM6.68081 4.39062V7.98438C6.68081 8.58184 7.12759 9.0625 7.68293 9.0625H12.3595C12.9148 9.0625 13.3616 8.58184 13.3616 7.98438V4.39062C13.3616 3.79316 12.9148 3.3125 12.3595 3.3125H7.68293C7.12759 3.3125 6.68081 3.79316 6.68081 4.39062ZM15.3659 4.03125C15.3659 4.42656 15.6665 4.75 16.0339 4.75H18.0382C18.4056 4.75 18.7063 4.42656 18.7063 4.03125C18.7063 3.63594 18.4056 3.3125 18.0382 3.3125H16.0339C15.6665 3.3125 15.3659 3.63594 15.3659 4.03125ZM15.3659 8.34375C15.3659 8.73906 15.6665 9.0625 16.0339 9.0625H18.0382C18.4056 9.0625 18.7063 8.73906 18.7063 8.34375C18.7063 7.94844 18.4056 7.625 18.0382 7.625H16.0339C15.6665 7.625 15.3659 7.94844 15.3659 8.34375ZM6.68081 12.6562C6.68081 13.0516 6.98145 13.375 7.34889 13.375H18.0382C18.4056 13.375 18.7063 13.0516 18.7063 12.6562C18.7063 12.2609 18.4056 11.9375 18.0382 11.9375H7.34889C6.98145 11.9375 6.68081 12.2609 6.68081 12.6562ZM6.68081 16.9688C6.68081 17.3641 6.98145 17.6875 7.34889 17.6875H18.0382C18.4056 17.6875 18.7063 17.3641 18.7063 16.9688C18.7063 16.5734 18.4056 16.25 18.0382 16.25H7.34889C6.98145 16.25 6.68081 16.5734 6.68081 16.9688Z"
									fill="black" />
							</svg>
					</i>
						<div>Tất cả</div></li></a>
				<a
					href="/Project_J2EE/Search.jsp?page=post&value=<%=request.getParameter("value")%>"><li
					class='sidebar_left-menu-item <%=request.getParameter("page").equals("post") ? "sidebar_left-menu-item_active" : ""%>'><i>
							<svg width="22" height="23" viewBox="0 0 22 23" fill="none"
								xmlns="http://www.w3.org/2000/svg">
							<path
									d="M0 3.28571C0 1.47344 1.06522 0 2.3754 0H19.0032C20.3134 0 21.3786 1.47344 21.3786 3.28571V19.7143C21.3786 21.5266 20.3134 23 19.0032 23H2.3754C1.06522 23 0 21.5266 0 19.7143V3.28571ZM4.7508 13.1429C5.0658 13.1429 5.36789 12.9698 5.59063 12.6617C5.81336 12.3536 5.9385 11.9357 5.9385 11.5C5.9385 11.0643 5.81336 10.6464 5.59063 10.3383C5.36789 10.0302 5.0658 9.85714 4.7508 9.85714C4.4358 9.85714 4.1337 10.0302 3.91097 10.3383C3.68823 10.6464 3.5631 11.0643 3.5631 11.5C3.5631 11.9357 3.68823 12.3536 3.91097 12.6617C4.1337 12.9698 4.4358 13.1429 4.7508 13.1429ZM5.9385 6.57143C5.9385 6.13572 5.81336 5.71785 5.59063 5.40975C5.36789 5.10166 5.0658 4.92857 4.7508 4.92857C4.4358 4.92857 4.1337 5.10166 3.91097 5.40975C3.68823 5.71785 3.5631 6.13572 3.5631 6.57143C3.5631 7.00714 3.68823 7.42501 3.91097 7.7331C4.1337 8.0412 4.4358 8.21429 4.7508 8.21429C5.0658 8.21429 5.36789 8.0412 5.59063 7.7331C5.81336 7.42501 5.9385 7.00714 5.9385 6.57143ZM4.7508 18.0714C5.0658 18.0714 5.36789 17.8983 5.59063 17.5902C5.81336 17.2822 5.9385 16.8643 5.9385 16.4286C5.9385 15.9929 5.81336 15.575 5.59063 15.2669C5.36789 14.9588 5.0658 14.7857 4.7508 14.7857C4.4358 14.7857 4.1337 14.9588 3.91097 15.2669C3.68823 15.575 3.5631 15.9929 3.5631 16.4286C3.5631 16.8643 3.68823 17.2822 3.91097 17.5902C4.1337 17.8983 4.4358 18.0714 4.7508 18.0714ZM8.3139 5.33929C7.82026 5.33929 7.42312 5.88862 7.42312 6.57143C7.42312 7.25424 7.82026 7.80357 8.3139 7.80357H16.6278C17.1214 7.80357 17.5186 7.25424 17.5186 6.57143C17.5186 5.88862 17.1214 5.33929 16.6278 5.33929H8.3139ZM8.3139 10.2679C7.82026 10.2679 7.42312 10.8172 7.42312 11.5C7.42312 12.1828 7.82026 12.7321 8.3139 12.7321H16.6278C17.1214 12.7321 17.5186 12.1828 17.5186 11.5C17.5186 10.8172 17.1214 10.2679 16.6278 10.2679H8.3139ZM8.3139 15.1964C7.82026 15.1964 7.42312 15.7458 7.42312 16.4286C7.42312 17.1114 7.82026 17.6607 8.3139 17.6607H16.6278C17.1214 17.6607 17.5186 17.1114 17.5186 16.4286C17.5186 15.7458 17.1214 15.1964 16.6278 15.1964H8.3139Z"
									fill="black" />
							</svg>

					</i>
						<div>Bài viết</div></li></a>
				<a
					href="/Project_J2EE/Search.jsp?page=user&value=<%=request.getParameter("value")%>">
					<li
					class='sidebar_left-menu-item <%=request.getParameter("page").equals("user") ? "sidebar_left-menu-item_active" : ""%>'><i>
							<svg width="22" height="23" viewBox="0 0 22 23" fill="none"
								xmlns="http://www.w3.org/2000/svg">
							<path
									d="M11.0423 11.5C12.6623 11.5 14.2159 10.8942 15.3615 9.81586C16.507 8.73753 17.1505 7.27499 17.1505 5.75C17.1505 4.22501 16.507 2.76247 15.3615 1.68414C14.2159 0.605802 12.6623 0 11.0423 0C9.42234 0 7.8687 0.605802 6.72319 1.68414C5.57769 2.76247 4.93415 4.22501 4.93415 5.75C4.93415 7.27499 5.57769 8.73753 6.72319 9.81586C7.8687 10.8942 9.42234 11.5 11.0423 11.5ZM8.86152 13.6562C4.16109 13.6562 0.353027 17.241 0.353027 21.6658C0.353027 22.4025 0.987704 23 1.77031 23H20.3143C21.0969 23 21.7316 22.4025 21.7316 21.6658C21.7316 17.241 17.9236 13.6562 13.2231 13.6562H8.86152Z"
									fill="black" />
							</svg>
					</i>
						<div>Người dùng</div></li>
				</a>
			</ul>
		</div>

		<div class="sidebar_left-center">
			<div class="sidebar_left-follow-section">
				<p class="sidebar_left-follow-heading">Bộ lọc</p>
			</div>
			<div class="sidebar_left_search-filter">
				<label for="sidebar_left_search-filter_every"
					class="sidebar_left_search-filter_left">Từ bất kì ai</label> <input
					id="sidebar_left_search-filter_every"
					name="sidebar_left_search-filter"
					class="sidebar_left_search-filter_right" value="all" checked
					type="radio" />
			</div>
			<div class="sidebar_left_search-filter">
				<label for="sidebar_left_search-filter_friend"
					class="sidebar_left_search-filter_left">Bạn bè</label> <input
					id="sidebar_left_search-filter_friend"
					name="sidebar_left_search-filter"
					class="sidebar_left_search-filter_right" value="friend"
					type="radio" />
			</div>
		</div>
	</div>
</div>
<div class="toolkit_message-wrapper"></div>
