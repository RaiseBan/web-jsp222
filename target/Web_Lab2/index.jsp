<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="models.Point" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lab1Ser</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="shortcut icon" href="img/SmileFace.ico" type="image/png">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
</head>
<body>
<div>
    <header class="header">
        <div>
                <span>
                    Shornikov Sergey Andreevich 369078 Variant 2100
                </span>
        </div>
    </header>
</div>

<div class="main">
    <div class="div-canvas">
        <canvas id="canvas" width="600" height="500">
            <!--сюда надо припилить график-->


        </canvas>

    </div>

    <div class="sendForm">
        <form>

            <div class="params-container">
                <label id="label-x">x = 0</label>
                <div id="choose-x">
                    <button type="button" id="b1" value="-2" onclick="set_X(id)">-2</button>
                    <button type="button" id="b2" value="-1.5" onclick="set_X(id)">-1.5</button>
                    <button type="button" id="b3" value="-1" onclick="set_X(id)">-1</button>
                    <button type="button" id="b4" value="-0.5" onclick="set_X(id)">-0.5</button>
                    <button type="button" id="b5" value="0" onclick="set_X(id)">0</button>
                    <button type="button" id="b6" value="0.5" onclick="set_X(id)">0.5</button>
                    <button type="button" id="b7" value="1" onclick="set_X(id)">1</button>
                    <button type="button" id="b8" value="1.5" onclick="set_X(id)">1.5</button>
                    <button type="button" id="b9" value="2" onclick="set_X(id)">2</button>
                </div>

            </div>
            <div class="params-container">
                <div id="choose-y">
                    <label id="label-y" for="input-y">y = </label>
                    <input type="text" id="input-y" name="y" placeholder="Input value" maxlength="6">
                </div>
            </div>

            <div class="params-container">
                <div id="choose-r">
                    <label id="label-r" for="select-r">r = 2</label>
                    <select id="select-r" onchange="selectR()">
                        <option value="1" id="sel_1">1</option>
                        <option value="1.5" id="sel_2">1.5</option>
                        <option value="2" id="sel_3" selected>2</option>
                        <option value="2.5" id="sel_4">2.5</option>
                        <option value="3" id="sel_5">3</option>
                    </select>
                </div>
            </div>

            <div class="params-container">
                <input type="submit" id="sendButton" value="Send data">
                <button type="button" id="clear-button">Clear table</button>
            </div>

        </form>
    </div>


    <div class="table-container">
        <%
            @SuppressWarnings("unchecked")
            List<Point> results = (List<Point>) session.getAttribute("result");

            if (results == null) {
                results = new ArrayList<>();
                session.setAttribute("result", results);
        %>
        <table class="table" id="result-table">
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>RESULT</th>
            </tr>
            </thead>
        </table>
        <%
        } else {
            // Итерация по списку результатов и вывод их в таблицу
            DecimalFormat df = new DecimalFormat("0.######");
        %>
        <table class="table" id="result-table">
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>RESULT</th>
            </tr>
            </thead>
            <tbody id="table_out">
            <%
                for (Point res : results) {
            %>
            <tr>
                <td><%= df.format(res.getX()) %></td>
                <td><%= df.format(res.getY()) %></td>
                <td><%= df.format(res.getR()) %></td>
                <td><%= res.isinArea() ? "<span>In</span>" : "<span>Out</span>" %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <%
            }
        %>
    </div>
    <script type="text/javascript" src="scripts/validation.js"></script>
    <script type="text/javascript" src="scripts/canvas.js"></script>
    <script type="text/javascript" src="scripts/sendData.js"></script>
    <script type="text/javascript" src="scripts/changeStyles.js"></script>
    <script type="text/javascript" src="scripts/clickOnCanvas.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

</div>
</body>
</html>