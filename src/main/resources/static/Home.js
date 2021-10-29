const URL = "http://localhost:8081/";

let addUserButton = document.getElementById('addUserButton');

addUserButton.onclick = addUser;

async function addUser() {

  console.log("Adding User");

  let employee = {

    username:document.getElementById('usernameEntry').value,
    password:document.getElementById('passwordEntry').value,
    firstname:document.getElementById('firstNameEntry').value,
    lastname:document.getElementById('lastNameEntry').value

  }

  let response = await fetch(URL + "employees", {

    method:"POST",
    body:JSON.stringify(employee),
    credentials:"include" // << Saves Cookie When Received

  });

  if (response.status === 200) {

    console.log("User Created");

  }
  else {

    console.log("Failed To Create User");

  }

}