$(document).ready(() => {
    $('#mh-content').toggle();
    $('#cn-content').toggle();
    let data = '';
    let redCDR = (ds_cdr) => {
        let cdr = '';
        ds_cdr.forEach((item, index) => {
            cdr += item.chuanDauRaMonHoc + " " + item.ketQua + "% ";
        })
        return cdr;
    }
    let add_lop_mh = (ds_lopmh) => {
        ds_lopmh.forEach((element, index) => {
            console.log(element);
            $('#ds_sv_lmh').append(
                    "<tr>\n\
                                <td><b>" + (index + 1) + "</b></td>\n\
                                   <td>" + element.tenSV + "</td>\n\
                                <td>" + element.diemqt + "</td>\n\
                                <td>" + element.diemgk + "</td>\n\
                                <td>" + element.diemth + "</td>\n\
                                <td>" + element.diemck + "</td>\n\
                                <td>" + ((element.diemqt + element.diemgk + element.diemth + element.diemck) / 4) + "</td>\n\
                                <td>" + redCDR(element.listCDR_MH) + "</td>\n\
                            </tr>"
                    )
        });
    }
    $('.gv').click((event) => {
        let id = event.target.id;
        $.ajax({
            type: 'POST',
            data: {id: id},
            url: 'http://localhost:8080/ChuanDauRa/AjaxTruongKhoa',
            success: (result) => {
                data = JSON.parse(result);
                if (data.danhSachLopCN)
                {
                    $('#ds_sv_lmh').empty();
                    add_lop_mh(data.danhSachLopMH[0].ds_SV)
                }
            }
        })
    })
    $('#title-mh').click(() => {
        $('#mh-content').toggle();
    })
    $('#title-cn').click(() => {
        $('#sailorTableArea').toggle();
    })

})













