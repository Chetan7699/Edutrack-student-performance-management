
function validateForm() {
    let roll = document.getElementById("roll") ? document.getElementById("roll").value.trim() : "";
    let sname = document.getElementById("sname") ? document.getElementById("sname").value.trim() : "";
    let course = document.getElementById("course") ? document.getElementById("course").value.trim() : "";
    let cj = document.getElementById("cj") ? document.getElementById("cj").value.trim() : "";
    let ajava = document.getElementById("ajava") ? document.getElementById("ajava").value.trim() : "";
    let html = document.getElementById("html") ? document.getElementById("html").value.trim() : "";
    let db = document.getElementById("db") ? document.getElementById("db").value.trim() : "";
    let c = document.getElementById("c") ? document.getElementById("c").value.trim() : "";
    let js = document.getElementById("js") ? document.getElementById("js").value.trim() : "";

    let uname = document.getElementById("uname") ? document.getElementById("uname").value.trim() : ""; // Admin login
    let pass = document.getElementById("pass") ? document.getElementById("pass").value.trim() : ""; // Admin login
    let rno = document.getElementById("rno") ? document.getElementById("rno").value.trim() : ""; // Student login

    let marksRegex = /^(100|[0-9]{1,2})$/;

    
    if (uname && pass) {
        if (!uname || !pass) {
            alert("Admin Username and Password are required!");
            return false;
        }
        return true;
    }

    
    if (rno) {
        if (!rno) {
            alert("Student Roll Number is required!");
            return false;
        }
        return true;
    }

    
    if (roll && sname && course && cj && ajava && html && db && c && js) {
        if (!marksRegex.test(cj) || !marksRegex.test(ajava) || !marksRegex.test(html) ||
            !marksRegex.test(db) || !marksRegex.test(c) || !marksRegex.test(js)) {
            alert("Marks must be between 0 and 100!");
            return false;
        }
        return true;
    }

    alert("All fields are required!");
    return false;
}
