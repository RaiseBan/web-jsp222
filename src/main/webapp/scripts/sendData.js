function sendData(xVal, yVal, rVal) {
    $(document).ready(function () {
        let params = {
            x: xVal,
            y: yVal,
            r: rVal
        };

        $.ajax({
            url: 'controller',
            type: 'POST',
            data: params,
            dataType: 'json'
        }).done(function (response, textStatus, jqXHR) {
            if (jqXHR.status === 200) {
                const table = document.getElementById('result-table');
                const row = table.insertRow(-1);
                const cell1 = row.insertCell(0);
                const cell2 = row.insertCell(1);
                const cell3 = row.insertCell(2);
                const cell4 = row.insertCell(3);

                cell1.textContent = userInputX;
                cell1.className = "new-cell";
                cell2.textContent = userInputY;
                cell2.className = "new-cell";
                cell3.textContent = userInputR;
                cell3.className = "new-cell";
                cell4.textContent = response.result;

                drawPoint(response.result);
            } else {
                console.log("Not a 200 status");
                throw new Error();
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            console.log('Error:', textStatus, errorThrown, jqXHR.status);
        });
    });
}
