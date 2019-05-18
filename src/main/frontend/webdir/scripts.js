function postDataAndAddRow(){
    //get values
    var firstNameString = this.document.getElementById("firstName").value;
    var lastNameString = this.document.getElementById("lastName").value;
    
    post(firstNameString, lastNameString);
}

function updateStudent() {
    var dataToSend = JSON.stringify({
        id: this.document.getElementById("id").value,
        firstName: this.document.getElementById("firstName").value,
        lastName: this.document.getElementById("lastName").value});
    
    this.$.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/",
        contentType: "application/json",
        data: dataToSend,
        success: function () {
        },
        complete: function (){
            showStudents();
        },
        dataType: 'json',
    });
}

function deleteStudent(){
    var url = "http://localhost:8080/api/" + this.document.getElementById("id").value;
    this.$.ajax({
        type: "DELETE",
        url: url,
        contentType: "application/json",
        success: function () {
        },
        complete: function (){
            showStudents();
        },
        dataType: 'json',
    });
}

function showStudents(){
    this.$.ajax({
        type: "GET",
        url: "http://localhost:8080/api/",
        contentType: "application/json",
        success: function (data) {
            clearRows();
            for(var i = 0; i < data.length; i++){
                addRow(data[i].id, data[i].firstName, data[i].lastName);
            }
        },
        dataType: 'json'
    });
}

function post(firstName, lastName){
    var dataToSend = JSON.stringify({
        firstName: firstName,
        lastName: lastName});
        
    this.$.ajax({
        type: "POST",
        url: "http://localhost:8080/api/",
        data: dataToSend,
        contentType: "application/json",
        success: function (data) {
            addRow(data.id, data.firstName, data.lastName);
        },
        dataType: 'json'
    });
}

function clearRows(){
    this.document.getElementById("table").innerHTML = "";
}

function addRow(id, firstName, lastName){
    var document = this.document;
    if (!document.getElementById("table")) return;
    
    var tabBody=document.getElementById("table");
    
    var row=document.createElement("tr");
    
    var idData = document.createElement("td");
    var firstNameData = document.createElement("td");
    var lastNameData = document.createElement("td");
    
    var idNode = document.createTextNode(id);
    var firstNameNode = document.createTextNode(firstName);
    var lastNameNode = document.createTextNode(lastName);
    
    idData.appendChild(idNode);
    firstNameData.appendChild(firstNameNode);
    lastNameData.appendChild(lastNameNode);
    
    row.appendChild(idData);
    row.appendChild(firstNameData);
    row.appendChild(lastNameData);
        
    tabBody.appendChild(row);
}