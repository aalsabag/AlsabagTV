
let ad_class_names = ['_63myj5r _lk70fcs', '_zb9zv92 _egf31ph', '_zyjw2i2 _bu8cnqq', 'megbylsm', '_vgbnxwp', '_hyaprrm', 'ad_asd' ];
let ad_id_names = ['ad_asd'];
// Removing large ads
for (let i = 0; i < ad_class_names.length; i++) {
  try {
  	document.getElementsByClassName(ad_class_names[i])[0].remove();
  } catch(error) {
  	console.log('failed to remove by class name' + ad_class_names[i]);
  }
}
for (let i = 0; i < ad_id_names.length; i++) {
  try {
  	document.getElementById(ad_id_names[i]).remove();
  } catch(error) {
  	console.log('failed to remove by id ' + ad_id_names[i]);
  }
}

let click_class_names = ['_9ehkpq', '_aeonhsr', '_6sdryz9']
// Removing click ads
for (let i = 0; i < click_class_names.length; i++) {
  try {
  	document.getElementsByClassName(click_class_names[i])[0].click();
  } catch(error) {
  	console.log('failed to remove by clicking ' + click_class_names[i]);
  }
}

// Removing youtube ads
try {
	var element = document.getElementsByTagName('iframe');
    if (element[0]) { 
        if(element[0].name.includes('youtube')){ 
        	console.log('removing youtube ad')
            element[1].remove(); 
        }else {
        	console.log('removing youtube ad')
            document.getElementsByTagName('iframe')[0].remove();
        }
    } 
} catch (error) { 
    console.log('failed to remove youtube ad')
}

// Auto play
try {  
    if (document.getElementById('player')){
        var searchEles = document.getElementById('player').children; 
        for(var i = 0; i < searchEles.length; i++) { 
            if(searchEles[i].id == 'player') { 
                searchEles[i].play(); 
            } 
        } 
        document.getElementById('player').play();
    } 
} catch (error) { 
    console.log('first autoplay fail');
}


try { 
    if (document.getElementById('1player_2')){
        document.getElementById('1player_2').play();
    }
} catch (error) { 
    console.log('second autoplay fail'); 
}

//Rezize videos
 try { 
    var elms = document.getElementById('player').getElementsByTagName('*'); 
    for (var i = 0; i < elms.length; i) { 
        if (elms[i].id === 'player') { 
            elms[i].style['object-fit'] = 'cover'; 
            break; 
        }
    }
} catch(error) { 
    console.log('failed to resize video'); 
} 

// Misc
if (document.querySelectorAll('html > div').length == 1) {document.querySelector('html > div').remove()}

console.log('script complete!')

