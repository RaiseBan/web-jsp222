let canvas = document.getElementById('canvas')
let ctx = canvas.getContext('2d');

canvas.addEventListener('click', function (event){
    const rect = canvas.getBoundingClientRect();

    // Координаты клика относительно canvas
    const clickedX = event.clientX - rect.left;
    const clickedY = event.clientY - rect.top;

    const rVal = document.getElementById("select-r")
        .options[document.getElementById("select-r")
        .options.selectedIndex].value;
    const graphX = (clickedX - widthCenter) * rVal / 100;
    const graphY = (heightCenter - clickedY) * rVal / 100;


    console.log("COORDINATES::");
    console.log(graphX);
    console.log(graphY);
    console.log(rVal);
    userInputX = graphX;
    userInputY = graphY;

    if (rVal.length !== 0){
        sendData(graphX, graphY, rVal);
    } else {
        Toastify({
            text: "You must have chosen R range",
            className: "error",
            style: {
                background: "linear-gradient(to right, #ff6347, #ff0000)",
                border: "1px solid white",
                'font-size': "20px"
            },
            offset: {
                x: 0,
                y: 0
            },
            position: "center",
        }).showToast();
    }



})