const main = {
    init : function () {
        const _this = this;
        document.getElementById('btn-save').onclick = function() {
            _this.save();
        };

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        // s3로 이미지 전송 로직

        //그 다음 아래 data에 s3로 들어간 이미지 주소 포함시켜
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),

            // image: 주소 솰라솰라,
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        const id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        const id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();

function fileCheck(obj) {
    const pathpoint = obj.value.lastIndexOf('.');
    const filepoint = obj.value.substring(pathpoint+1,obj.length);
    const filetype = filepoint.toLowerCase();
    if(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp') {
    } else {
        alert('이미지 파일만 선택할 수 있습니다.');
        const parentObj  = obj.parentNode;
        const node = parentObj.replaceChild(obj.cloneNode(true),obj);
        location.reload();
    }

    if(filetype=='bmp') {
        const upload = confirm('BMP 파일은 웹상에서 사용하기엔 적절한 이미지 포맷이 아닙니다.\n그래도 계속 하시겠습니까?');
        location.reload();
    }
    if(!upload) {
        location.reload();
    }
}
