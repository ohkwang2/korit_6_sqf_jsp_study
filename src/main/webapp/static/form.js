//form 태그 안에 들어있는 데이터들을 일반 데이터 형태로 변환하는 메소드
function handleSubmitAllClick(){
	const forms = document.querySelectorAll("form");
	const formData1 = new FormData(forms[0]);
	const formData2 = new FormData(forms[1]);
	
	// 최종적으로 reqData를 만들어서 활용해야 함.
	let reqData = {}
	
	/**
		formData1 = {
			username: "admin",
			password: "1234"
		}
		
		entries = [
			["username", "admin"],
			["password", "1234"]
		];
	 */
	
	for(let entry of formData1.entries()) {
		const [ key, value ] = entry;
		reqData = {
			...reqData,
			[key]: value
		}
	}
	
	let duplicatedKeys = [];
	let keyCount = {}
	
	
	/**
	formData2 = {
		chk: "chk1",
		chk: "chk2",
		rdo: "rdo1"
	}
	
	entries = [
		["chk", "chk1"],
		["chk", "chk2"],
		["rdo", "rdo1"]
	];
	 */
	 
	 
	for(let key of formData2.keys()) {
		if(Object.keys(keyCount).includes(key)) {
			keyCount = {
				...keyCount,
				[key]: keyCount[key] + 1
			}
			continue;			
		}
		keyCount = {
			...keyCount,
			[key]: 1
		}
	}
	
	for(let key of Object.keys(keyCount)) {
		if(keyCount[key] > 1) {
			duplicatedKeys = [ ...duplicatedKeys, key ];
		}
	}
	
	console.log(keyCount);
	console.log(duplicatedKeys);
	
	// entries -> [key, value]의 묶음을 의미
	for(let entry of formData2.entries()) {
		console.log(entry);
		const [ key, value ] = entry;
		if(duplicatedKeys.includes(key)) {
			reqData = {
				...reqData,
				[key]: [ ...(!reqData[key] ? []: reqData[key]), value]
			}
		continue;			
		}
		reqData = {
			...reqData,
			[key]: value
		}
	}
	
	console.log(reqData);
	
	const queryString = new URLSearchParams(reqData).toString();	
	
	fetch(`http://localhost:8080/dvd/form?${queryString}`)
	.then(response => {
		response.text()
		.then(data => {
			const body = document.querySelector("body");
			body.innerHTML += `<h1>${data}</h1>`;
			console.log(data);
		})
	});
}