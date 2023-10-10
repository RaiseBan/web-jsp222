// Получаем все кнопки с классом "color-button"
const divElement = document.getElementById('choose-x');
const buttonsInDiv = divElement.querySelectorAll('button');


// Добавляем обработчик события клика на каждую кнопку
buttonsInDiv.forEach(button => {
    button.addEventListener('click', () => {
        // Удаляем класс "active" у всех кнопок
        buttonsInDiv.forEach(btn => btn.classList.remove('active'));

        // Добавляем класс "active" только кнопке, на которую был клик
        button.classList.add('active');
    });
});

let clearButton = document.getElementById("clear-button");
clearButton.onclick = function (){
    clearSession();
}
function clearSession() {
    $.ajax({
        url: 'controller', // Замените на реальный путь к вашему ControllerServlet
        type: 'POST',
        data: { action: 'clearSession' },
        success: function(response) {
            // Обработка успешного завершения. Например, обновление UI
            Toastify({
                text: "отчистка успешна",
                duration: 2000,
                style:{
                    background: "green"
                }
            }).showToast();
            clearSavedState();
            clearSavedState();
            location.reload();


        },
        error: function(xhr, status, error) {
            // Обработка ошибок
            alert('Произошла ошибка при очистке сессии');
        }
    });
}