function deleteObject(endpoint, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint + id, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                alert("Xóa thành công!");
                location.reload();
            } else
                alert("Có lỗi xảy ra!");
        });
    }
}
function populateSubjectEditModal(button) {
    const id = button.getAttribute("data-id");
    const subjectCode = button.getAttribute("data-subjectCode");
    const subjectName = button.getAttribute("data-subjectName");
    const credits = button.getAttribute("data-credits");
    const description = button.getAttribute("data-description");

    document.getElementById("edit-id").value = id;
    document.getElementById("edit-subjectCode").value = subjectCode;
    document.getElementById("edit-subjectName").value = subjectName;
    document.getElementById("edit-credits").value = credits;
    document.getElementById("edit-description").value = description;

    // Gán action cho form: /subjects/{id}
    document.getElementById("editSubjectForm").action = "/StudyScoreWebAPI/subjects/" + id;
}
function populateEditClassModal(button) {
    const id = button.getAttribute('data-id');
    const code = button.getAttribute('data-code');
    const name = button.getAttribute('data-name');
    const lecturerId = button.getAttribute('data-lecturer-id');

    document.getElementById('edit-id').value = id;
    document.getElementById('edit-code').value = code;
    document.getElementById('edit-name').value = name;

    const lecturerSelect = document.getElementById('edit-lecturer');
    if (lecturerSelect) {
        lecturerSelect.value = lecturerId;
    }
    
    document.getElementById('editClassForm').action = '/StudyScoreWebAPI/classes/' + id;
}
function populateEditClassSubjectModal(button) {
    const id = button.getAttribute('data-id');
    const classId = button.getAttribute('data-class-id');
    const subjectId = button.getAttribute('data-subject-id');
    const lecturerId = button.getAttribute('data-lecturer-id');

    document.getElementById('edit-cs-id').value = id;
    document.getElementById('edit-class').value = classId;
    document.getElementById('edit-subject').value = subjectId;

    const lecturerSelect = document.getElementById('edit-lecturer');
    if (lecturerId && lecturerSelect) {
        lecturerSelect.value = lecturerId;
    } else if (lecturerSelect) {
        lecturerSelect.value = ""; // trường hợp chưa phân công
    }

    // Cập nhật action của form
    document.getElementById('editClassSubjectForm').action = '/StudyScoreWebAPI/classSubjects/' + id;
}
function populateEditScoreModal(button) {
    const id = button.getAttribute('data-id');
    const studentId = button.getAttribute('data-student-id');
    const classSubjectId = button.getAttribute('data-class-subject-id');
    const midtermScore = button.getAttribute('data-midterm-score');
    const finalScore = button.getAttribute('data-final-score');
    const extra1 = button.getAttribute('data-extra1');
    const extra2 = button.getAttribute('data-extra2');
    const extra3 = button.getAttribute('data-extra3');
    const lockStatus = button.getAttribute('data-lock-status');

    document.getElementById('edit-id').value = id;
    document.getElementById('edit-studentId').value = studentId;
    document.getElementById('edit-class-subjectId').value = classSubjectId;
    document.getElementById('edit-midterm-score').value = midtermScore;
    document.getElementById('edit-final-score').value = finalScore;
    document.getElementById('edit-extra1').value = extra1;
    document.getElementById('edit-extra2').value = extra2;
    document.getElementById('edit-extra3').value = extra3;
    document.getElementById('edit-lock-status').value = lockStatus;

    // Cập nhật action cho form nếu cần gửi đúng đến từng bản ghi
    document.getElementById('editScoreForm').action = '/StudyScoreWebAPI/scores/' + id;
}
