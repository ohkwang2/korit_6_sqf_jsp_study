function handleSearchClick() {
	const searchInput = document.querySelector(".search-input");
	location.href = `http://localhost:8080/dvd/search?searchText=${searchInput.value}`;
};

function handleInputKeyDown(e) {
	const searchInput = document.querySelector(".search-input");
	if(event.keyCode === 13){
		handleSearchClick();
	};
};