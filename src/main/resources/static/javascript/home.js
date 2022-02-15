const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
let caseChoice = document.getElementById('user_case')
let cpuChoice = document.getElementById('user_cpu')
let cpuCoolerChoice = document.getElementById('user_cpuCooler')
let gpuChoice = document.getElementById('user_gpu')
let motherboardChoice = document.getElementById('user_motherboard')
let psuChoice = document.getElementById('user_psu')
let ramChoice = document.getElementById('user_ram')
let storageChoice = document.getElementById('user_storage')

const headers = {
    'Content-Type': 'application/json'
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateCaseChoice = (obj) =>{
    caseChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    caseChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateCpuChoice = (obj) =>{
    cpuChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    cpuChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateCpuCoolerChoice = (obj) =>{
    cpuCoolerChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    cpuCoolerChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateGpuChoice = (obj) =>{
    gpuChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    gpuChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateMotherboardChoice = (obj) =>{
    motherboardChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    motherboardChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populatePsuChoice = (obj) =>{
    psuChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    psuChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateRamChoice = (obj) =>{
    ramChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    ramChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

const populateStorageChoice = (obj) =>{
    storageChoice.innerHTML = '';
    if (!obj){
        obj = {
            name: '',
            brand: ''
        }
    }

    storageChoice.innerHTML = `
    <div>
        <span class="">${obj.brand} ${obj.name}</span>
    </div>
    `
}

async function getCart()
{
    let repsonse = await fetch("http://localhost:8080/api/v1/users/" + userId, {
        method: "GET",
        headers: headers
    })
        .catch(err => console.error(err))
    let responseArr = await repsonse.json();

    let cartObject = responseArr[0];
    populateCaseChoice(cartObject.casw);
    populateCpuChoice(cartObject.cpu);
    populateCpuCoolerChoice(cartObject.cpuCooler);
    populateGpuChoice(cartObject.gpu);
    populateMotherboardChoice(cartObject.motherboard);
    populatePsuChoice(cartObject.psu);
    populateRamChoice(cartObject.ram);
    populateStorageChoice(cartObject.storage)

    console.log(responseArr[0]);
}

getCart();