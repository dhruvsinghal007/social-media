function showUsersByPage() {
    var pageNumber = $("#pageNumber").val();
    var pageSize = $("#pageSize").val();
    sendAjax("/users?pageNumber=" + pageNumber + "&pageLength=" + pageSize, "GET", {}, handleSuccessShowUsersByPage, handleFailure);
}

function showFriendsOfUser() {
    var id = $("#userId1").val();
    sendAjax("/users/" + id + "/friends", "GET", {}, handleSuccessShowFriendsOfUser, handleFailure);
}

function showFriendsOfFriendsOfUser() {
    var id = $("#userId2").val();
    sendAjax("/users/" + id + "/friendsoffriends", "GET", {}, handleSuccessShowFriendsOfFriendsOfUser, handleFailure);
}

function handleSuccessShowUsersByPage(data) {
    console.log(data);
    $("#usersPaginated").empty();
    if(data.length > 0){
    	$("#usersPaginated").append(createTableData(data));
    }
}

function handleSuccessShowFriendsOfUser(data) {
    console.log(data);
    $("#usersFriends").empty();
    if(data.length > 0){
    	$("#usersFriends").append(createTableData(data));
    }
}

function handleSuccessShowFriendsOfFriendsOfUser(data) {
    console.log(data);
    $("#usersFriendsOfFriends").empty();
    if(data.length > 0){
    	$("#usersFriendsOfFriends").append(createTableData(data));
    }
}

function handleFailure(error) {
	alert(error.responseJSON.message);
}

function sendAjax(url, type, data, callbackFunc, errorCallbackFunc) {
    $.ajax({
        url: url,
        type: type,
        contentType: "application/json;",
        data: data, // Stringified Json Object
        success: function (response) {
            callbackFunc(response);
        },
        error: function (response) {
            errorCallbackFunc(response)
        },
        timeout: 90000
        // 90 sec
    });
}

function createTableData(data){
	var $table = $("<table />");
    var $tr = $("<tr />");
    var $td1 = $("<th />").html('User Id');
    var $td2 = $("<th />").html('First Name');
    var $td3 = $("<th />").html('Last Name');
    var $td4 = $("<th />").html('Avatar');
    $tr.append($td1);
    $tr.append($td2);
    $tr.append($td3);
    $tr.append($td4);
    $table.append($tr);
    for(let i = 0; i < data.length; i++){
    	$td1 = $("<td />").html(data[i].id);
    	$td2 = $("<td />").html(data[i].firstName);
    	$td3 = $("<td />").html(data[i].lastName);
    	$td4 = $("<td />").html(data[i].avatar);
    	$tr = $("<tr />");
    	$tr.append($td1);
        $tr.append($td2);
        $tr.append($td3);
        $tr.append($td4);
        $table.append($tr);
    }
    return $table;
}
