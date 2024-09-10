document.addEventListener("DOMContentLoaded", function() {
    // 버튼 ID 가져오기 : html에서 버튼의 아이디 가져오기
    const checkUserIdButton = document.getElementById("checkUserId");
    // 선택자 가져오기 : 입력한 사용자 아이디 값 가져오기
    const userIdInput = document.getElementById("userId");
    const registerButton = document.querySelector("button[type='submit']");

    let isUserIdValid = false;

    checkUserIdButton.addEventListener("click", function() {
        const userId = userIdInput.value;

        if (!userId) {
            alert("아이디를 입력하세요.");
            return;
        }

        // 서버에 userId를 보내서 중복 여부를 확인
        fetch(`/checkUserId?userId=${userId}`)
            .then(response => response.json())
            .then(data => {
                if (data) {

                    alert("이미 사용 중인 아이디입니다.");
                    isUserIdValid = false;
                    registerButton.disabled = true;  // 회원가입 버튼 비활성화
                } else {
                    alert("사용 가능한 아이디입니다.");
                    isUserIdValid = true;
                    registerButton.disabled = false; // 회원가입 버튼 활성화
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("아이디 중복검사 중 오류가 발생했습니다.");
                isUserIdValid = false;
                registerButton.disabled = true; // 오류 시에도 비활성화
            });
    });

    userIdInput.addEventListener("input", function() {
        // 사용자 입력 중에 아이디 검사가 필요하기 때문에 버튼을 비활성화
        isUserIdValid = false;
        registerButton.disabled = true;
    });
});
