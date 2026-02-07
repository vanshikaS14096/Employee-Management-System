const API = "http://localhost:8080/getEmp";
const POST_API = "http://localhost:8080/addEmp";

loadEmployees();

function loadEmployees(){

fetch(API)
.then(res => res.json())
.then(data => {

 let table = document.getElementById("tableBody");
 table.innerHTML = "";

 for(let i=0;i<data.length;i++){

  let emp = data[i];

  table.innerHTML +=
   "<tr>" +
   "<td>"+emp.id+"</td>" +
   "<td>"+emp.name+"</td>" +
   "<td>"+emp.salary+"</td>" +
   "<td>"+emp.age+"</td>"
   "</tr>";
 }
});
}

document.getElementById("addBtn").onclick = () => {
 document.getElementById("formBox").style.display="block";
};
document.getElementById("delete").onclick = () => {
 document.getElementById("deleteid").style.display = "block";
};
document.getElementById("updateBtn").onclick = () => {
 document.getElementById("updateBox").style.display = "block";
};



function saveEmployee(){

 let name = document.getElementById("name").value;
 let salary = document.getElementById("salary").value;
 let age = document.getElementById("age").value;

 fetch(POST_API,{
   method:"POST",
   headers:{"Content-Type":"application/json"},
   body: JSON.stringify({
     name:name,
     salary:salary,
     age:age
   })
 })
 .then(()=> {
   loadEmployees();
   document.getElementById("formBox").style.display="none";
 });
}

document.getElementById("confirmDelete").onclick = () => {

 let id = document.getElementById("id").value;

 if(id === ""){
   alert("Enter employee ID first");
   return;
 }

 fetch("http://localhost:8080/delete/" + id,{
   method:"DELETE"
 })
 .then(()=>{
   loadEmployees();
   document.getElementById("id").value = "";
 });

};
document.getElementById("updateBtn").onclick = () => {
 document.getElementById("updateBox").style.display = "block";
};

document.getElementById("updateBtn").onclick = () => {
 document.getElementById("updateBox").style.display = "block";
};

document.getElementById("confirmUpdate").onclick = () => {

 let id = document.getElementById("uid").value;
 let name = document.getElementById("uname").value;
 let salary = document.getElementById("usalary").value;
 let age = document.getElementById("uage").value;

 if(id === ""){
   alert("Enter Employee ID");
   return;
 }

 fetch("http://localhost:8080/updateEmp/" + id,{
   method:"PUT",
   headers:{"Content-Type":"application/json"},
   body: JSON.stringify({
     name:name,
     salary:salary,
     age:age
   })
})

 .then(()=>{
   loadEmployees();
   document.getElementById("updateBox").style.display="none";
 });

};

