# ElAhmad TV
An android app for Elahmad tv that is designed for Fire Televisions by automatically removing ads

## javascript executed
```javascript
javascript:(function() { 
	try { 
		var element = document.getElementsByTagName('iframe');
		if (element[0]) {
			if(element[0].name.includes('youtube')){
				element[1].remove();
			}else {
				document.getElementsByTagName('iframe')[0].remove();
			}
		}
	} catch (error) {
		console.log(error);
		console.log("error 1");
	}
	try {
		document.getElementsByClassName("_zb9zv92 _egf31ph")[0].remove();
	} catch (error) {
		console.log(error);
		console.log("error 5");
	}
  try {
		document.getElementsByClassName("_zyjw2i2 _bu8cnqq")[0].remove();
	} catch (error) {
		console.log(error);
		console.log("error 5");
	}

	try {
		document.getElementsByClassName("megbylsm")[0].remove();
	} catch (error) {
		console.log(error);
		console.log("error 6");
	}
	if (document.getElementsByClassName("_9ehkpq")[0]){
		document.getElementsByClassName("_9ehkpq")[0].click()
	}
	if (document.getElementsByClassName("_aeonhsr")[0]){
		document.getElementsByClassName("_aeonhsr")[0].click()
	}
	if (document.getElementById("ad_asd")){
		document.getElementById("ad_asd").remove()
	}
	try { 
		if (document.getElementById("player")){
			var searchEles = document.getElementById("player").children;
			for(var i = 0; i < searchEles.length; i++) {
				if(searchEles[i].id == 'player') {
					searchEles[i].play();
				}
			}
			document.getElementById("player").play();
		}
	} catch (error) {
		console.log(error);
		console.log("error 2");
	}try {
		if (document.getElementById("1player_2")){
			document.getElementById("1player_2").play()
		}
	} catch (error) {
		console.log(error);
		console.log("error 3");
	}
	try {
		document.getElementsByClassName("_6sdryz9")[0].click();
	} catch (error) {
		console.log(error);
		console.log("error 4");
	}

	try {
		var elms = document.getElementById("player").getElementsByTagName("*");
		for (var i = 0; i < elms.length; i++) {
			if (elms[i].id === "player") {
				elms[i].style["object-fit"] = "cover";
				break;
			}
		}
	} catch(error) {
		console.log(error);
		console.log("error 6");
	}
})()
```

## Channels to test
Aljazeera
Sky News
alarabiya
Sudan TV
Blue Nile
Omdurman
MBC 2/3
Nile Comedy
