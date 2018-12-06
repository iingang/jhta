// ----- ex10-종합 테스트 : DOM 조작 능력이 있는가?? -----------
window.addEventListener("load", function(){
	var ex10 = document.querySelector("#ex10");

	var notices = [
		{id:1, title:"javascript 란?", writerId:"newlec"},
		{id:2, title:"너희들이 서블릿을 알아?", writerId:"newlec"},
		{id:3, title:"안다고~ 난 좀 쩔지~~ㅋㅋ?", writerId:"nolec"}
	];
	var bind = function(tr, notice){
		var idTd = tr.querySelector(".id");
		var titleTd = tr.querySelector(".title");
		var writerIdTd = tr.querySelector(".writer-id");

		idTd.innerText = notice.id;
		titleTd.innerText = notice.title;
		writerIdTd.innerText = notice.writerId;

		//4. 데이터를 심는 작업 추가 //data-id값 넣어줌. 이걸 타겟 데이터셋으로 꺼낼수있다.
		var aEdit = tr.querySelector(".edit");
		aEdit.dataset.id = notice.id;

		tbody.appendChild(tr);

	};

	var template = ex10.querySelector(".row-template");
	var tbody = ex10.querySelector("tbody");

	//1. 위의 데이터로 초기 테이블의 tr 설정해 주세요.

	var btnAdd = ex10.querySelector('input[name="btn-add"]');
	var table = ex10.querySelector("table");

	
	for(var i=0; i<notices.length; i++){
		var tr = document.importNode(template.content, true);
		bind(tr,notices[i]);
		// table.appendChild(tr);
	}


	var txtId = ex10.querySelector("input[name='id']");
	var txtTitle = ex10.querySelector("input[name='title']");
	var txtWriterId = ex10.querySelector("input[name='writer-id']");


	//2. add 버튼을 클릭하면 실행되는 함수블록을 추가
	btnAdd.onclick = function(e){

		//입력한 데이터를 notices 배열에 추가한다.
		//tr 들을 모두 지운다.
		//tbody.innerHTML = "";
		
		// 이런식으로 해도 돼!
		// var notice = {};
		// notice.id = txtId.value;
		notices.push({id:txtId.value, title:txtTitle.value, writerId:txtWriterId.value});
		tbody.innerHTML = "";
		
		// console.log(notices.length);
	
		for(var i=0; i<notices.length; i++){
			var tr = document.importNode(template.content, true);
			bind(tr,notices[i]);
		}
	};

	//체크박스 일괄선택되게!
	var chkHeader = ex10.querySelector('thead input[type="checkbox"]');
	chkHeader.onclick = function(){
		// console.log(chkHeader.checked);
		var chkboxes = ex10.querySelectorAll('tbody td:first-child input');
		var st = chkHeader.checked;
		for(var i=0; i<chkboxes.length;i++)
			chkboxes[i].checked = st;
		
	};

	//이거 되는거

	// var edit = ex10.querySelector("tbody");

	// edit.addEventListener("click",function(e){
	// 	//console.log(e.target.nodeName);
		
	// 	// console.log(e.target.className);
	// 	if(e.target.className != "edit") return;

	// 	alert("Hello");

	// },true);

	
	//=========================3. 일괄삭제버튼 =========================== 
	var removeBtn = ex10.querySelector('input[name="btn-del-all"]');
	
	
	removeBtn.onclick = function(){
		
		//이 체크박스는 안에서 선언해줘야돼!!!!! 멍청아!!!!!! 그러지좀마!!!
		var chkboxes = ex10.querySelectorAll('tbody td:first-child input');
		
		for(var i=chkboxes.length-1; i>=0; i--){
			if(chkboxes[i].checked)
				notices.splice(i,1);
		
		}

		//이렇게 밑으로 테이블 갱신해준다고 생각해!
		tbody.innerHTML = "";
		for(var i=0; i<notices.length; i++){
			var tr = document.importNode(template.content, true);
			bind(tr,notices[i]);
		}

	};

	//================ 4. 수정/삭제 버튼 구현 ======================


	tbody.onclick = function(e){
		if(e.target.classList.contains("edit")){
 
			var id = e.target.dataset.id;//-를 사용한 모든 애들은 set을 사용하여 표현할 수 있다
	 
			var notice = null;
			for(var i=0; i<notices.length ; i++){
	 
				 if(notices[i].id == id){
					 notice = notices[i];
					 break;
				 }
			 }
	 
			txtId.value = notice.id;
			txtTitle.value = notice.title;
			txtWriterId.value = notice.writerId;
	 
			e.preventDefault(); //기본행위를 막아주는 행동 새로고침이 되지 않는다.
		 }
	};


});

// // ----- ex10-종합 테스트 : DOM 조작 능력이 있는가?? -----------
// window.addEventListener("load", function(){
// 	var ex10 = document.querySelector("#ex10");

// 	var notices = [
// 		{id:1, title:"javascript 란?", writerId:"newlec"},
// 		{id:2, title:"너희들이 서블릿을 알아?", writerId:"newlec"},
// 		{id:3, title:"안다고~ 난 좀 쩔지~~ㅋㅋ?", writerId:"nolec"}
// 	];
// 	var bind = function(tr, notice){
// 		var idTd = tr.querySelector(".id");
// 		var titleTd = tr.querySelector(".title");
// 		var writerIdTd = tr.querySelector(".writer-id");

// 		idTd.innerText = notice.id;
// 		titleTd.innerText = notice.title;
// 		writerIdTd.innerText = notice.writerId;

// 		//4. 데이터를 심는 작업 추가 //data-id값 넣어줌. 이걸 타겟 데이터셋으로 꺼낼수있다.
// 		var aEdit = tr.querySelector(".edit");
// 		aEdit.dataset.id = notice.id;


// 		tbody.appendChild(tr);

// 	};

// 	var template = ex10.querySelector(".row-template");
// 	var tbody = ex10.querySelector("tbody");

// 	//1. 위의 데이터로 초기 테이블의 tr 설정해 주세요.

// 	var btnAdd = ex10.querySelector('input[name="btn-add"]');
// 	var table = ex10.querySelector("table");

	
// 	for(var i=0; i<notices.length; i++){
// 		var tr = document.importNode(template.content, true);
// 		bind(tr,notices[i]);
// 		// table.appendChild(tr);
// 	}


// 	var txtId = ex10.querySelector("input[name='id']");
// 	var txtTitle = ex10.querySelector("input[name='title']");
// 	var txtWriterId = ex10.querySelector("input[name='writer-id']");


// 	//2. add 버튼을 클릭하면 실행되는 함수블록을 추가
// 	btnAdd.onclick = function(e){

// 		//입력한 데이터를 notices 배열에 추가한다.
// 		//tr 들을 모두 지운다.
// 		//tbody.innerHTML = "";
		
// 		// 이런식으로 해도 돼!
// 		// var notice = {};
// 		// notice.id = txtId.value;

		
// 		notices.push({id:txtId.value, title:txtTitle.value, writerId:txtWriterId.value});
// 		// console.log(notices.length);
// 		tbody.innerHTML = "";
// 		for(var i=0; i<notices.length; i++){
// 			var tr = document.importNode(template.content, true);
// 			bind(tr,notices[i]);
// 		}
// 	};

// 	//체크박스 일괄선택되게!
// 	var chkHeader = ex10.querySelector('thead input[type="checkbox"]');
// 	chkHeader.onclick = function(){
// 		// console.log(chkHeader.checked);
// 		var chkboxes = ex10.querySelectorAll('tbody td:first-child input');
// 		var st = chkHeader.checked;
// 		for(var i=0; i<chkboxes.length;i++)
// 			chkboxes[i].checked = st;
		
// 	};

// 	//이거 되는거

// 	// var edit = ex10.querySelector("tbody");

// 	// edit.addEventListener("click",function(e){
// 	// 	//console.log(e.target.nodeName);
		
// 	// 	// console.log(e.target.className);
// 	// 	if(e.target.className != "edit") return;

// 	// 	alert("Hello");

// 	// },true);

	
// 	//=========================3. 일괄삭제버튼 =========================== 
// 	var removeBtn = ex10.querySelector('input[name="btn-del-all"]');
// 	var chkboxes = ex10.querySelectorAll('tbody td:first-child input');
	
// 	removeBtn.onclick = function(){
// 		// notices.splice(1,1);
// 		// for(var i=notices.length-1; i>=0; i--){
// 		// 	if(chkboxes[i].checked)
// 		// 		notices.splice(i,1);
		
// 		// }

// 	  for(var i=chkboxes.length-1; i>=0; i--)
//       {
//          if(chkboxes[i].checked)
//          {
//             notices.splice(i,1);         
//          }      
//       }

// 		//이렇게 밑으로 테이블 갱신해준다고 생각해!
// 		tbody.innerHTML = "";
// 		for(var i=0; i<notices.length; i++){
// 			var tr = document.importNode(template.content, true);
// 			bind(tr,notices[i]);
// 		}

// 	};

// 	//================ 4. 수정/삭제 버튼 구현 ======================


// 	tbody.onclick = function(e){
// 		if(e.target.classList.contains("edit")){
// 			alert(e.target.dataset.id);

// 			//기본행위 막기
// 			e.preventDefault();
// 		};
// 	}


// });


/*--- ex9-이벤트 객체 트리거: 사진파일 선택하기 -----------------------*/ 
window.addEventListener("load", function(){
	var ex9 = document.querySelector("#ex9");

	var btnFile = ex9.querySelector('input[type="file"]')
	var btnImg = ex9.querySelector(".btn-img");

	btnImg.onclick = function(e){
		var evt = new MouseEvent("click",{
			"view":window,
			"bubbles":true,
			"cancelable":true
		});

		btnFile.dispatchEvent(evt);
	}

});
/*--- ex8-이벤트 객체: 이미지 변경 -----------------------*/ 
window.addEventListener("load", function(){
	var ex8 = document.querySelector("#ex8");
	var imgList = ex8.querySelector(".img-list");

	var imgs = ex8.querySelectorAll(".img-list img");
	var img = ex8.querySelector(".img");


	//2. 버블링을 이용하기 위해 부모 객체에 이벤트를 설정
	//imgList.onclick = function(e){
	imgList.addEventListener("click",function(e){
		//console.log(e.target.nodeName);

		if(e.target.nodeName != "IMG") return;
		//블럭이 많아지면 안좋은코드! 역발상이 필요하다! 이렇게 위코드처럼 조건안만족시키면 먼저 리턴시켜서 밑에거실행안되게!
		img.src=e.target.src;

		console.log("imgList");

	},true);

	//imgs[0].onclick = function(e){
	imgs[0].addEventListener("click",function(e){
		e.target.style.border = "2px solid red";
		
		e.stopPropagation();
		console.log("img[0]");
	},true);


	// 1. 다음과 같은 코드는 최악의 코드!! : 버블링을 이용할것
	// for(var i=0; i<imgs.length; i++)
	// 	imgs[i].onclick = function(){
	// 		var idx = i;
	// 		img.src = img[idx].src;
	// 	};

});

/*--- ex7-노드조작-노드복제: 레코드 목록추가 -----------------------*/ 
window.addEventListener("load", function(){
	var ex7 = document.querySelector("#ex7");
	var btnAdd = ex7.querySelector('input[value="add"]');

	var txtId = ex7.querySelector('input[name="id"]');
	var txtTitle = ex7.querySelector('input[name="title"]');
	var txtWriterId = ex7.querySelector('input[name="writer-id"]');

	var table = ex7.querySelector("table");

	var template = ex7.querySelector("#row-template");
	var originTr = table.querySelector("tbody tr:first-child");

	btnAdd.onclick = function(){
		//var tr = originTr.cloneNode(true);
		var tr = document.importNode(template.content, true);
		var idTd = tr.querySelector(".id");
		var titleTd = tr.querySelector(".title");
		var writerIdTd = tr.querySelector(".writer-id");


		idTd.innerText = txtId.value;
		titleTd.innerText = txtTitle.value;
		writerIdTd.innerText = txtWriterId.value;

		table.appendChild(tr);
	};
});



/*--- ex6-노드조작: 메뉴추가하기 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){

	var menus = [
		{id:1, title:"jsp 짱!", url:"http://www.naver.com"},
		{id:2, title:"javascript가 더 짱!!", url:"http://www.daum.net"}
	]
	
	var ex6 = document.querySelector("#ex6");
	var txtTitle = ex6.querySelector('input[name="title"]');
	var btnAdd = ex6.querySelector('input[name="btn-add"]');
	var menuList = ex6.querySelector('.menu-list');
	
	btnAdd.onclick = function()
    {
		var li = document.createElement("li");

		li.innerHTML = '<a href = "http://www.newlecture.com" class = "btn btn-default">hello <span>'+txtTitle.value+'</span></a>';

		menuList.appendChild(li);
		// var txt = document.createTextNode(txtTitle.value);
		// var a = document.createElement("a");
		// a.href = "http://www.naver.com";

		//li.appendChild(txt);
		//appendChild - 1개
		//append - 2개이상 넣을수있다.

		// a.append(txt);
		// li.append(a);
		//menuList.appendChild(li);
	
    }
	
});

/*--- ex5-css 속성 조작 : 이미지 스타일 변경 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){
	
	var ex5 = document.querySelector("#ex5"); 
	var img = ex5.querySelector("img");
	//var width = ex5.querySelector("input:first-child");
	var width = ex5.querySelector("input[name='width']"); //input의 기본은 name이야 name로 비교해 !!
	var height = ex5.querySelector("input[name='height']");
	var color = ex5.querySelector("input[name='color']");
	
	var btnChange = ex5.querySelector("input[type='button']");
	
	btnChange.onclick = function()
    {
		//img.style.width ="100px";
		img.style.width = width.value+"px";
		img.style.height = height.value+"px";
		//img.style.["border-color"]="";
		img.style.borderColor = "#"+color.value;
		img.style.borderWidth = "3px";
		img.style.borderStyle = "solid";
    }; 
});

/*--- ex4-속성 조작 : 이미지 변경 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){
	
	var ex4 = document.querySelector("#ex4"); //css가 아이디찾을 때 # 하잖아
	
	var btnChange = ex4.querySelector("input[type='button']"); //여러개는 뒤에 All이 붙음 
	
	var img = ex4.querySelector("img");
	var input = ex4.querySelector("input:first-child");
	
	var imgCategory = ex4.querySelector("select");
	
	imgCategory.onchange = function(){
		img.src = "images/"+imgCategory.value;
	}
	
	btnChange.onclick = function()
    {
		img.src = input.value;
    }; 
    
});



/*--- ex3-노드 선택 API: 계산기3 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){
	
	var ex3 = document.querySelector("#ex3"); //css가 아이디찾을 때 # 하잖아
	
	var inputs = ex3.querySelectorAll("input"); //여러개는 뒤에 All이 붙음 
	
	var btnAdd = inputs[2];
	var txtX = ex3.querySelector("input:first-child");// css에서 썼던 선택자를 이렇게 다쓸수있다 ~~//inputs[0];
	var txtY = ex3.querySelector("input:nth-child(2)");//ex3.querySelector("input:first-child+input");//inputs[1];
	var txtSum = inputs[3];
	
	btnAdd.onclick = function()
    {
		var x = parseInt(txtX.value);
		var y = parseInt(txtY.value);
        txtSum.value = x+y;
    }; 
    
});


/*--- ex2-노드 선택: 계산기2 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){
	
	var ex2 = document.getElementById("ex2");
	
	var inputs = ex2.getElementsByTagName("input");
	
	var btnAdd = inputs[2];
	var txtX = inputs[0];
	var txtY = inputs[1];
	var txtSum = inputs[3];
	
	btnAdd.onclick = function()
    {
		var x = parseInt(txtX.value);
		var y = parseInt(txtY.value);
        txtSum.value = x+y;
    }; 
    
});


/*---ex1: 계산기 -----------------------*/ 
//window.onload = function(){
window.addEventListener("load", function(){
	var btnAdd = document.getElementById("btn-add");
	var txtX = document.getElementById("txt-x");
	var txtY = document.getElementById("txt-y");
	var txtSum = document.getElementById("txt-sum");
	
	btnAdd.onclick = function()
    {
		var x = parseInt(txtX.value);
		var y = parseInt(txtY.value);
        txtSum.value = x+y;
    }; 
    
});


/* --------------------------- */
//indow.onload = function(){
window.addEventListener("load", function(){
	var btnPrint = document.getElementById("btn-print");
	
    btnPrint.onclick = function()
    {
        var x,y;
        x=prompt("x 입력");
        y=prompt("y 입력");
        x=parseInt(x);
        y=parseInt(y);
        btnPrint.value = x+y;
    }; //세미콜론이 있는 이유는 저 = 때문이야! 함수만 선언할때는 세미콜론 필요없어!! 
    
});

