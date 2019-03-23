function getRequest(url, onSuccess, onError) {
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        success: onSuccess,
        error: onError
    });
}

function postRequest(url, data, onSuccess, onError) {
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        data: data,
        contentType: 'application/json',
        processData: false,
        success: onSuccess,
        error: onError
    });
}