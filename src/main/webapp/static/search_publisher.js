
function handleSearchButtonClick(){
	const inputSearch = document.querySelector(".input-search");
	location.href = `http://localhost:8080/dvd/publisher/search?searchText=${inputSearch.value}`;
}
function handleInputKeyDown(e) {
	const inputSearch = document.querySelector(".input-search");
	if(event.keyCode === 13) {
		handleSearchButtonClick();
	}
}