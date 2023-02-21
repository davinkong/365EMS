
//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("note-form")
const noteContainer = document.getElementById("note-container")

//Modal Elements
let noteBody = document.getElementById(`note-body`)
let updateNoteBtn = document.getElementById('update-note-button')


const dFrom = new Date();

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/pto"

if (employeeId == null){
    window.alert("You are not authorized to access this page...");
    window.location.replace("http://localhost:8080/html/login.html");
}
const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        ptoRequestAmount: document.getElementById("note-input").value,
        ptoFrom: document.getElementById("date-from").value.Date,
        ptoTo: document.getElementById("date-to").value.Date,
        ptoApproved: 0
    }
    await requestPto(bodyObj);
    document.getElementById("note-input").value = ''
    document.getElementById("date-from").value = ''
    document.getElementById("date-to").value = ''

}

async function requestPto(obj) {
    const response = await fetch(`${baseUrl}/employee/${employeeId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getPtoByEmployee(employeeId);
    }
}

async function getPtoByEmployee(employeeId) {
    await fetch(`${baseUrl}/employee/${employeeId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createNoteCards(data))
        .catch(err => console.error(err))
}

async function handleDelete(ptoId){
    await fetch(baseUrl +`/`+ ptoId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getPtoByEmployee(employeeId);
}

async function getPtoById(ptoId){
    await fetch(baseUrl+`/` + ptoId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}



const createNoteCards = (array) => {
    noteContainer.innerHTML = ''
    array.forEach(obj => {
        let noteCard = document.createElement("div")
        noteCard.classList.add("m-2")
        noteCard.innerHTML = `
<!--            <div class="form-group" style="max-width: 960px; margin: 16px auto; padding: 16px">-->
                <div class="row">
                     <div class="col-sm-3">
                        <div class="card" >
                            <div class="card-body flex-column  justify-content-between" style="height: available">
                                <p class="card-text text-danger">Request Pending: <strong>-${obj.ptoRequestAmount}</strong> </p>
                                <p class="card-text text-success">Aprroved PTO amount: <strong>${obj.ptoApproved}</strong></p>
                                <p class="card-text text-info">From: <strong>${obj.ptoFrom.toString().substring(0, 10)}</strong></p>
                                <p class="card-text text-info">To:   <strong>${obj.ptoTo.toString().substring(0, 10)}</strong></p>

                                <div class="d-flex justify-content-between">
                                <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Cancel Request</button>  
                                </div>
                            </div>
                        </div>
                     </div>
                </div>
<!--            </div>-->
        `
        noteContainer.append(noteCard);
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateModal = (obj) =>{
    noteBody.innerText = ''
    noteBody.innerText = obj.ptoRequestAmount
    noteBody.innerText = ''
    noteBody.innerText = obj.ptoFrom
    noteBody.innerText = ''
    noteBody.innerText = obj.ptoTo
    updateNoteBtn.setAttribute('data-note-id', obj.id)
}

getPtoByEmployee(employeeId);

submitForm.addEventListener("submit", handleSubmit)

// updateNoteBtn.addEventListener("click", (e)=>{
//     let ptoId = e.target.getAttribute('data-note-id')
//     handleNoteEdit(ptoId);
// })