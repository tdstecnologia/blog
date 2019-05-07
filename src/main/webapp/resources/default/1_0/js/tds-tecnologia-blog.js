/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Exibe um loading de status do request ajax
 * Uso:  <f:ajax onevent="loading" />
 * @param {type} data
 * @returns {undefined} loading-status-ajax-request
 */
function loading(data) {
    var ajaxstatus = data.status;
    var spinner = document.getElementById("loading-status-ajax-request");
    switch (ajaxstatus) {
        case "begin":
            spinner.style.visibility = "visible";
            break;
        case "complete":
            spinner.style.visibility = "hidden";
            break;
    }
}



