/** @format */

let arr = [
  { id: 1, name: "john", age: "18", profession: "developer" },
  { id: 2, name: "jack", age: "20", profession: "developer" },
  { id: 3, name: "karen", age: "19", profession: "admin" },
];

function PrintDeveloperbyMap() {
  //Write your code here , just console.log
  arr.map(employee =>{
    if(employee.profession ==='developer'){
      console.log(employee);
    }

  });
}

function PrintDeveloperbyForEach() {
  //Write your code here , just console.log
  arr.forEach(employee =>{
    if(employee.profession ==='developer'){
      console.log(employee);
    }

  });

}

function addData() {
  //Write your code here, just console.log
const newEmployeeToAdd = {id:4,name:"susan",age:"20",profession:"intern"} ;
arr.push(newEmployeeToAdd);
console.log(newEmployeeToAdd);
}

function removeAdmin() {
  //Write your code here, just console.log
  arr = arr.filter(employee =>employee.profession !=='admin');
  console.log(arr);

}

function concatenateArray() {
  //Write your code here, just console.log
  let arr2 = [
    { id: 4, name: "ravi", age: "22", profession: "tester" },
    { id: 5, name: "shruti", age: "32", profession: "designer" },
    { id: 6, name: "rutuja", age: "34", profession: "intern" },
  ];  

  const concatenateArray1 = arr.concat(arr2);
  console.log(concatenateArray1);
}