
function handleSearchButtonClick() {
	const searchInput = document.querySelector(".search-input");
	location.href = `http://localhost:8080/dvd/producer/search?searchText=${searchInput.value}`;
}

function handleInputKeyDown(e) {
	const searchInput = document.querySelector(".search-input");
	if(event.keyCode === 13){
		handleSearchButtonClick();
	}
}