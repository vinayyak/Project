$(document).ready(function() {

    $('#selectedState').on('change', function () {
        const stateNo = $(this).val();
        const getCitiesFromStateURL = '/vinni-demo/states/' + stateNo + '/cities/all';
        $.ajax({
            type: 'GET',
            url: getCitiesFromStateURL,
            success: function (result) {
                var result = JSON.parse(result);
                var s = '';
                for (let i = 0; i < result.length; i++) {
                    s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                }
                $('#selectedState').html(s);
            }
        });

    });

})


