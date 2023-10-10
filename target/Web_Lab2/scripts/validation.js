// let input = document.getElementById().
let button = document.getElementById("sendButton");
let flag = false;
let userInputY = 0;
let userInputX = 0;
let userInputR = 2;

function selectR () {
    userInputR = document.getElementById("select-r")
        .options[document.getElementById("select-r")
        .options.selectedIndex].value;
    console.log("r" + userInputR);
    document.getElementById("label-r").innerText = "r = " + userInputR;
    draw();
}
function set_X(id){
    userInputX = parseFloat(document.getElementById(id).value);
    document.getElementById("label-x").innerText = "x = " + userInputX;
    console.log("x" + userInputX);

}

function checkY (){
    userInputY = document.getElementById("input-y");
    if(isNaN(userInputY.value) || userInputY.value === ''){

        flag = false
        Toastify({
            text: "ну не, не подходит чиселко",
            duration: 3000,
            close: true,
            gravity: "top", // `top` or `bottom`
            position: "left", // `left`, `center` or `right`
            stopOnFocus: true, // Prevents dismissing of toast on hover
            style: {
                background: "linear-gradient(to right, #6e8580, #0c2b2a)",
            },
            onClick: function(){} // Callback after click
        }).showToast();
    }else{
        if (userInputY.value >= -5 && userInputY.value <= 5){
            flag = true;
            document.getElementById("label-y").innerText = "y = " + userInputY.value;
            userInputY = userInputY.value;
            console.log("y" + userInputY);
            console.log("sdfghpjksdhiopwsefio[h");
        }else{
            flag = false
            Toastify({
                text: "Значение Y не валидно (-5; 5)",
                duration: 3000,
                close: true,
                gravity: "top", // `top` or `bottom`
                position: "left", // `left`, `center` or `right`
                stopOnFocus: true, // Prevents dismissing of toast on hover
                style: {
                    background: "linear-gradient(to right, #6e8580, #0c2b2a)",
                },
                onClick: function(){} // Callback after click
            }).showToast();
        }
    }

}
button.onclick = function (event){
    event.preventDefault();
    checkY();
    if (flag){
        console.log("sendData");
        sendData(userInputX, userInputY, userInputR);

    }

}