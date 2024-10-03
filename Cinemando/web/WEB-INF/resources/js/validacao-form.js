function emailValidate() {
    var email = document.getElementById('email').value;
    var emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var span = document.querySelector('.span-required'); // Obtém o elemento <span>
    var input = document.getElementById('email'); // Obtém o elemento <input>

    if (!emailRegex.test(email)) {
        // O email é inválido
        span.style.display = 'block'; 
        input.style.border = '2px solid red'; 
    } 
    else {
        // O email é válido
        span.style.display = 'none'; 
        input.style.border = ''; 
    }
}

