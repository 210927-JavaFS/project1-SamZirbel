const URL = "http://localhost:8081/";


let loginButton = document.getElementById('loginButton');
let addUserButton = document.getElementById('addUserButton');

let updateAccountButton = document.createElement("button");
updateAccountButton.setAttribute('id', 'updateAccountButton');
updateAccountButton.innerText = "Update Account";

let enterRequestButton = document.createElement("button");
enterRequestButton.setAttribute('id', "enterRequestButton");
enterRequestButton.innerText = "Submit Reimbursement Request";

let submitRequestButton = document.createElement("button");
submitRequestButton.setAttribute('id', "submitRequestButton");
submitRequestButton.innerText = "Submit Request!!";

let viewMyRequestsButton = document.createElement("button");
viewMyRequestsButton.setAttribute('id', "viewMyRequestsButton");
viewMyRequestsButton.innerText = "View All My Requests";

loginButton.onclick = loginFunction;
addUserButton.onclick = addUserFunction;
updateAccountButton.onclick = updateAccountFunction;
enterRequestButton.onclick = newReimbursementFunction;
submitRequestButton.onclick = submitNewReimbursement;
viewMyRequestsButton.onclick = displayMyRequests;



let pendingNewUsername = "";
let pendingNewPassword = "";

let loggedInUser = "";
let loggedInPass = "";
let loggedInAccount = null;
let loggedInAccountType = "Employee";

let incorrectLogin = 0;



async function loginFunction () {

  console.log("Log In Button Pressed");

  loggedInUser = document.getElementById('usernameLogin').value;
  loggedInPass = document.getElementById('passwordLogin').value;

  let sender = {

    "username" : loggedInUser,
    "password" : loggedInPass,
    "account" : null

  }

  console.log(sender);

  let response = await fetch(URL + "checker/1", {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  console.log("!!!!!!!!!!!!");
  console.log("User Found : " + data);
  console.log("\n");

  if (!data) {

    loggedInUser = "";
    loggedInPass = "";
    if (incorrectLogin == 0) {

      let loginDiv = document.getElementById('loginDiv');

      let incorrectPara = document.createElement('p');
      incorrectPara.setAttribute('id', 'incorrectLoginPara');
      incorrectPara.setAttribute('style', "color: red");
      incorrectPara.innerText = "Wrong Log In Information";

      loginDiv.appendChild(incorrectPara);

      incorrectLogin = 1;

    }

  }
  else {

    console.log("Correct Login");

    let body1 = document.getElementById('loginDiv');
    let body2 = document.getElementById('newUserDiv');

    clearChildTags(body1);
    clearChildTags(body2);

    getEmployeeAccount();

    displayAccountOptions();


  }

}


async function getEmployeeAccount() {

  console.log("Fetching Employee Account");

  let sender = {

    "username" : loggedInUser,
    "password" : loggedInPass,
    "account" : null

  }

  console.log(sender);

  let response = await fetch(URL + "grabber", {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  loggedInAccount = data;

  
  loggedInAccountType = Object(loggedInAccount).accountType;
  
  console.log("!!!!!!!!!!!!");
  console.log("Account Type : " + loggedInAccountType);
  console.log("\n");


}

function displayAccountOptions() {

  console.log("Displaying Account Options");

  let optionsDiv = document.getElementById('accountOptionsDiv');

  clearChildTags(optionsDiv);

  optionsDiv.appendChild(enterRequestButton);

  optionsDiv.appendChild(viewMyRequestsButton);


}

async function displayMyRequests () {

  console.log("Displaying User Requests");

  let accountNumb = Object(loggedInAccount).accountID;

  let response = await fetch(URL + "reimb/" + accountNumb, { } );

  let data = await response.json();



  let tableDiv = document.getElementById('myRequestsDiv');

  let rtable = document.createElement("table");

  let rthead = document.createElement("thead");

  let trhead = document.createElement("tr");

  let thaccountNumber = document.createElement("th");
  thaccountNumber.innerText = "Account Number";
  trhead.appendChild(thaccountNumber);

  let thamount = document.createElement("th");
  thamount.innerText = "Amount";
  trhead.appendChild(thamount);

  let thansweredDate = document.createElement("th");
  thansweredDate.innerText = "Answered Date";
  trhead.appendChild(thansweredDate);

  let thdescription = document.createElement("th");
  thdescription.innerText = "description";
  trhead.appendChild(thdescription);

  let threquestID = document.createElement("th");
  threquestID.innerText = "Request Identification";
  trhead.appendChild(threquestID);

  let thstatus = document.createElement("th");
  thstatus.innerText = "Status";
  trhead.appendChild(thstatus);

  let thsubmittedDate = document.createElement("th");
  thsubmittedDate.innerText = "submittedDate";
  trhead.appendChild(thsubmittedDate);

  let thtype = document.createElement("th");
  thtype.innerText = "type";
  trhead.appendChild(thtype);

  rthead.appendChild(trhead);

  let rtbody = document.createElement("tbody");

  for (let obj of data) {

    let row = document.createElement("tr");

    console.log(Object(obj).type);

    let td1 = document.createElement("td");
    td1.innerText = Object(obj).accountNumber;
    row.appendChild(td1);

    let td2 = document.createElement("td");
    td2.innerText = Object(obj).amount;
    row.appendChild(td2);

    let td3 = document.createElement("td");
    td3.innerText = Object(obj).answeredDate;
    row.appendChild(td3);

    let td4 = document.createElement("td");
    td4.innerText = Object(obj).description;
    row.appendChild(td4);


    let td5 = document.createElement("td");
    td5.innerText = Object(obj).requestID;
    row.appendChild(td5);

    let td6 = document.createElement("td");
    td6.innerText = Object(obj).status;
    row.appendChild(td6);

    let td7 = document.createElement("td");
    td7.innerText = Object(obj).submittedDate;
    row.appendChild(td7);

    let td8 = document.createElement("td");
    td8.innerText = Object(obj).type;
    row.appendChild(td8);
  

    rtbody.appendChild(row);

  }

  rtable.appendChild(rthead);
  rtable.appendChild(rtbody);

  tableDiv.appendChild(rtable);

  

  viewMyRequestsButton.innerText = "Close My Requests";
  viewMyRequestsButton.onclick = closeMyRequests;


  console.log(data);
  console.log("\n");

}

function closeMyRequests () {

  clearChildTags(myRequestsDiv);

  viewMyRequestsButton.innerText = "View All My Requests";
  viewMyRequestsButton.onclick = displayMyRequests;

}

function newReimbursementFunction () {

  console.log("Preparing New Reimbursement");

  let optionsDiv = document.getElementById('accountOptionsDiv');

  clearChildTags(optionsDiv);

  
  let formvar = document.createElement("form");

  let label1 = document.createElement("label");
  label1.setAttribute('for', 'reimbAmountEntry');
  label1.innerText = "Dollar Amount";
  formvar.appendChild(label1);

  let input1 = document.createElement("input");
  input1.setAttribute('type', "text");
  input1.setAttribute('id', 'reimbAmountEntry');
  input1.setAttribute('name', 'reimbAmountEntry');
  formvar.appendChild(input1);

  let breaker01 = document.createElement("br");
  formvar.appendChild(breaker01);

    
  let label2 = document.createElement("label");
  label2.setAttribute('for', 'reimbTypeEntry');
  label2.innerText = "Reimbursement Type : Lodging, Travel, Food, Other";
  formvar.appendChild(label2);

  let input2 = document.createElement("input");
  input2.setAttribute('type', "text");
  input2.setAttribute('id', 'reimbTypeEntry');
  input2.setAttribute('name', 'reimbTypeEntry');
  formvar.appendChild(input2);

  let breaker02 = document.createElement("br");
  formvar.appendChild(breaker02);

  let label3 = document.createElement("label");
  label3.setAttribute('for', 'reimbDescriptionEntry');
  label3.innerText = "Reimbursement Description";
  formvar.appendChild(label3);

  let input3 = document.createElement("input");
  input3.setAttribute('type', "text");
  input3.setAttribute('id', 'reimbDescriptionEntry');
  input3.setAttribute('name', 'reimbDescriptionEntry');
  formvar.appendChild(input3);



  optionsDiv.appendChild(formvar);

  optionsDiv.appendChild(submitRequestButton);

}

async function submitNewReimbursement () {

  console.log("Submitting New Reimbursement");

  console.log(loggedInAccount);

  let postAmount = parseInt(document.getElementById('reimbAmountEntry').value);
  let accountNumb = Object(loggedInAccount).accountID;


  let sender = {

    //"requestID" : null,
    "accountNumber" : accountNumb,
    "status" : "Pending",
    "amount" : postAmount,
    "type" : document.getElementById('reimbTypeEntry').value,
    "submittedDate" : String(new Date()),
    "answeredDate" : "Pending",
    "description" : document.getElementById('reimbDescriptionEntry').value

  }

  console.log(sender);

  let response = await fetch(URL + "reimb", {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  console.log("!!!!!!!!!!!!");
  console.log("Reimbursement Posted : " + data);
  console.log("\n");

  displayAccountOptions();

}




function addUserFunction () {

  console.log("Attempting To Add User");

  pendingNewUsername = document.getElementById('newUsername').value;
  pendingNewPassword = document.getElementById('newPassword').value;

  console.log(pendingNewUsername);
  console.log(pendingNewPassword);

  ensureUniqueUsername();


}

async function ensureUniqueUsername () {

  console.log("Starting Unique Username Function");

  let sender = {

    "username" : pendingNewUsername,
    "password" : pendingNewPassword,
    "account" : null
    //"accounts" : null

  }

  console.log(sender);

  let response = await fetch(URL + "checker", {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  console.log(data);
  console.log("\n");

  if (data === true) {

    addUsername();



  }
  else {

    console.log("Username Taken");
    console.log("Unable To Create User");

  }

}

async function addUsername () {

  console.log("Starting Add New User Function");

  let sender = {

    "username" : pendingNewUsername,
    "password" : pendingNewPassword,
    "account" : null

  }

  console.log(sender);

  let response = await fetch(URL + "adder/user", {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  console.log("!!!!!!!!!!!!");
  console.log("User Added : " + data);
  console.log("\n");


  populateForAccountDetail();


}


function populateForAccountDetail() {

  let newUserDivBody = document.getElementById('newUserDiv');

  clearChildTags(newUserDivBody);

  let formvar = document.createElement("form");

  let label1 = document.createElement("label");
  label1.setAttribute('for', 'firstNameEntry');
  label1.innerText = "First Name";
  formvar.appendChild(label1);

  let input1 = document.createElement("input");
  input1.setAttribute('type', "text");
  input1.setAttribute('id', 'firstNameEntry');
  input1.setAttribute('name', 'firstNameEntry');
  formvar.appendChild(input1);

    
  let label2 = document.createElement("label");
  label2.setAttribute('for', 'lastNameEntry');
  label2.innerText = "Last Name";
  formvar.appendChild(label2);

  let input2 = document.createElement("input");
  input2.setAttribute('type', "text");
  input2.setAttribute('id', 'lastNameEntry');
  input2.setAttribute('name', 'lastNameEntry');
  formvar.appendChild(input2);


  let label3 = document.createElement("label");
  label3.setAttribute('for', 'accountTypeEntry');
  label3.innerText = "Account Type : Employee Or Manager?";
  formvar.appendChild(label3);

  let input3 = document.createElement("input");
  input3.setAttribute('type', "text");
  input3.setAttribute('id', 'accountTypeEntry');
  input3.setAttribute('name', 'accountTypeEntry');
  formvar.appendChild(input3);



  newUserDivBody.appendChild(formvar);

  newUserDivBody.appendChild(updateAccountButton);

}

async function updateAccountFunction () {

  console.log("Starting Update Account Function");

  console.log(document.getElementById('firstNameEntry').value);  

  let upFirstName = document.getElementById('firstNameEntry').value;
  let upLastName = document.getElementById('lastNameEntry').value;
  let upAccountType = document.getElementById('accountTypeEntry').value;

  let sender = {

    "login" : null,
    "firstName" : upFirstName,
    "lastName" : upLastName,
    "accountType" : upAccountType

  }

  console.log(sender);

  let response = await fetch(URL + "updater/" + pendingNewUsername, {

    method : 'POST',
    body : JSON.stringify(sender)

  });

  let data = await response.json();

  console.log("!!!!!!!!!!!!");
  console.log("Account Updated : " + data);
  console.log("\n");

}


function clearChildTags(body) {

  while (body.firstChild) {

    body.removeChild(body.firstChild);

  }

}