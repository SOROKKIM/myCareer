function updateCareer(id, title, content) {
    // 업데이트할 커리어 정보를 포함하는 객체 생성
    const updatedCareer = {
        title: title,
        content: content
    };

    axios.put(`/career/${id}`, updatedCareer, {
        headers: {
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        }
    })
    .then(function(response) {
        // 요청이 성공적으로 처리되었을 때를 대비한 처리
        alert("성공적으로 업데이트되었습니다.");
        window.location.href = '/';
    })
    .catch(function(error) {
        // 요청이 실패했을 때를 대비한 처리
        alert("업데이트에 실패했습니다.");
        console.error(error);
    });
}


function updateCancel() {
    // 메인 페이지로 이동
    window.location.href = '/';
}

document.querySelector('.buttonUpdate').addEventListener('click', function(e) {
    e.preventDefault(); // 폼 제출을 막기 위함

    // 제목과 내용 가져오기
    const title = document.querySelector('input[name="input"]').value;
    const content = $('#summernote').summernote('code');

    // createCareer 함수 호출
    updateCareer(title, content);
});


document.querySelector('.buttonCancel').addEventListener('click', function(e) {
    e.preventDefault(); // 폼 제출을 막기 위함

    // createCancel 함수 호출
    createCancel();
});