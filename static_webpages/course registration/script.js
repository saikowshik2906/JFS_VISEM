// Auto-calculate total fee
let subjects = document.querySelectorAll(".subject");
let totalBox = document.getElementById("total");

subjects.forEach(item => {
    item.addEventListener("change", () => {
        let total = 0;

        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });

        totalBox.innerText = "₹" + total;
    });
});

// Optional: form submit
document.getElementById("regForm").addEventListener("submit", function(e){
    e.preventDefault();

    let selectedSubjects = [];
    let totalFee = 0;

    subjects.forEach((sub) => {
        if (sub.checked) {
            // Get subject name from the label text
            let subjectName = sub.parentElement.innerText.trim();
            selectedSubjects.push(subjectName);
            totalFee += parseInt(sub.value);
        }
    });

    if (selectedSubjects.length === 0) {
        alert("Please select at least one subject.");
        return;
    }

    let studentName = document.getElementById("name").value;
    let numberedList = selectedSubjects
        .map((s, i) => (i + 1) + ". " + s)
        .join("\n");

    let message =
        "Student Name: " + studentName + "\n\n" +
        "Selected Subjects:\n" + numberedList + "\n\n" +
        "Total Fee: ₹" + totalFee;

    const finalDiv = document.getElementsByClassName("final")[0];
    finalDiv.innerHTML = '';

    const pre = document.createElement('pre');
    pre.textContent = message;
    pre.style.whiteSpace = 'pre-wrap';

    const closeBtn = document.createElement('button');
    closeBtn.type = 'button';
    closeBtn.id = 'closeFinal';
    closeBtn.textContent = 'Close';
    closeBtn.style.display = 'inline-block';
    closeBtn.style.marginTop = '10px';

    closeBtn.addEventListener('click', function() {
        finalDiv.style.display = 'none';
    });

    finalDiv.appendChild(pre);
    finalDiv.appendChild(closeBtn);

    finalDiv.style.display = 'block';
});
