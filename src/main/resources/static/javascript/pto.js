
//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("note-form")
const noteContainer = document.getElementById("note-container")

//Modal Elements
let noteBody = document.getElementById(`note-body`)
let updateNoteBtn = document.getElementById('update-note-button')




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
        ptoFrom: document.getElementById("date-from").value,
        ptoTo: document.getElementById("date-to").value,
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

                <div class="column">
                        <div class="card" >
                            <div class="container justify-content-between">
                            <table>
                            <br>
                                    <tr>
                                        <th class="text-danger">Pending:</th>
                                        <td class="text-danger">-${obj.ptoRequestAmount}</td>
                                    </tr>
                                    <tr>
                                        <th class="text-success">Aprroved:</th>
                                        <td class="text-success">${obj.ptoApproved}</td>
                                    </tr>
                                    <tr>
                                        <th>From:</th>
                                        <td>${obj.ptoFrom.toString().substring(5, 7)}/${obj.ptoFrom.toString().substring(8, 10)}/${obj.ptoFrom.toString().substring(0, 4)}</td>
                                    </tr>
                                    <tr>
                                        <th>To:</th>
                                        <td>${obj.ptoTo.toString().substring(5, 7)}/${obj.ptoTo.toString().substring(8, 10)}/${obj.ptoTo.toString().substring(0, 4)}</td>
                                    </tr>
                            </table>
     
                                <br>
                                <div class="d-flex justify-content-between">
                                <button class="btn btn-danger" style="text-align: center" onclick="handleDelete(${obj.id})">Cancel Request</button>  
                                </div>
                                <br>
                            </div>
                        </div>
                </div>

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