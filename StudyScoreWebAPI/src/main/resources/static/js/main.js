function deleteSubject(endpoint, id) {
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
function populateEditModal(button) {
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

function deleteClass(apiUrl, id) {
    if (confirm("Bạn có chắc chắn muốn xóa lớp này không?")) {
        fetch(apiUrl + id, {method: 'DELETE'})
                .then(res => {
                    if (res.ok)
                        window.location.reload();
                    else
                        alert("Không thể xóa lớp.");
                }
                );
    }
}