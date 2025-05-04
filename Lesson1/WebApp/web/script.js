function brightenText(input) {
  var label = document.querySelector('label[for=' + input.id + ']');
  label.style.color = 'White';
}


function darkenText(input){
    var label = document.querySelector('label[for=' + input.id + ']');
  label.style.color = 'rgb(93, 94, 114)';
}

