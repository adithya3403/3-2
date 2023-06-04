function addRecord() {
    var name = document.getElementById('name').value;
    var subject = document.getElementById('subject').value;
    var grade = document.getElementById('grade').value;
    var table = document.getElementById('academicTable').getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.rows.length);
    var nameCell = newRow.insertCell(0);
    var subjectCell = newRow.insertCell(1);
    var gradeCell = newRow.insertCell(2);
    nameCell.innerHTML = name;
    subjectCell.innerHTML = subject;
    gradeCell.innerHTML = grade;
    document.getElementById('name').value = '';
    document.getElementById('subject').value = '';
    document.getElementById('grade').value = '';
} 