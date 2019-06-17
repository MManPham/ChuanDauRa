$(document).ready(() => {
    let data = '';



    $('.list-gv > button').click(function (e) {
        // find/remove all active classes from each a
        $('.list-gv > button').removeClass('active');
        $(this).addClass('active');
    });
    myWeb = {
        Views: {
            displayLopMH: (index, sinhvien) => {
                return "<tr>\n\
                                <td><b>" + (index + 1) + "</b></td>\n\
                                   <td>" + sinhvien.tenSV + "</td>\n\
                                <td>" + sinhvien.diemqt + "</td>\n\
                                <td>" + sinhvien.diemgk + "</td>\n\
                                <td>" + sinhvien.diemth + "</td>\n\
                                <td>" + sinhvien.diemck + "</td>\n\
                                <td>" + ((sinhvien.diemqt + sinhvien.diemgk + sinhvien.diemth + sinhvien.diemck) / 4) + "</td>\n\
                                <td>" + myWeb.Modals.readCDR_MH(sinhvien.listCDR_MH) + "</td>\n\
                            </tr>"
            },
            displayLopCN: (sinhvien) => {
                StringReturn = "<tr><td>" + sinhvien.mssv + "</td> <td>" + myWeb.Modals.readCDR_KH(sinhvien.chuanDauRA_KH) + "</td>\n\
                                                 <td> <form action= '../LoginServlet' method='GET'>\n\
                                                    <input type='hidden' name='mssv' value='" + sinhvien.mssv + "' />\n\
                                                    <input class='btn btn-info' type='submit' value='Chi tiết' /></form></td>\n\
                                                </tr>"
                return StringReturn;
            }
        },
        Modals: {
            toggleLopMH: true,
            toggleLopCN: true,
            data: '',
            readCDR_MH: (ds_cdr) => {
                let cdr = '';
                ds_cdr.forEach((item, index) => {
                    cdr += item.chuanDauRaMonHoc + " " + item.ketQua + "% ";
                })
                return cdr;
            },
            readCDR_KH: (ds_cdr) => {
                let cdr = '';
                ds_cdr.forEach((item, index) => {
                    cdr += item.chuanDaura + " " + item.ketQua + "% ";
                })
                return cdr;
            },
            add_lop_mh: (ds_lopmh) => {
                ds_lopmh.forEach((element, index) => {
                    $('#ds_sv_lmh').append(myWeb.Views.displayLopMH(index, element))
                });
            },
            add_lop_cn: (ds_lopcn) => {
                $('#ds_ten_lcn').empty();
                ds_lopcn.forEach((lop_cn) => {
                    $('#ds_ten_lcn').append("<option>" + lop_cn.ten_Lop + "</option>")
                    lop_cn.ds_SV.forEach((sinhvien) => {
                        console.log(1111, sinhvien);
                        $('#ds_sv_cn').append(myWeb.Views.displayLopCN(sinhvien));
                    });
                })
            }


        },
        Controller: {
            get_append_data: () => {
                $('.gv').on('click', (event) => {
                    let id = event.target.id;
                    $.ajax({
                        type: 'POST',
                        data: {id: id},
                        url: 'http://localhost:8080/ChuanDauRa/AjaxTruongKhoa',
                        success: (result) => {
                            myWeb.Modals.data = JSON.parse(result);
                            let data = myWeb.Modals.data;
                            console.log(data);
                            if (data.danhSachLopMH) {
                                $('#ds_sv_lmh').empty();
                                myWeb.Modals.add_lop_mh(data.danhSachLopMH[0].ds_SV)
                            }
                            if (data.danhSachLopCN)
                            {
                                $('#ds_sv_cn').empty();
                                myWeb.Modals.add_lop_cn(data.danhSachLopCN)
                            }

                        }
                    })
                })
            },
            toggleLopMH: () => {
                $('#title-mh').click(() => {
                        if (myWeb.Modals.toggleLopMH === true)
                            $('div#_mh-content').show();
                        else
                            $('div#_mh-content').hide()
                        myWeb.Modals.toggleLopMH = !myWeb.Modals.toggleLopMH;
                });

            },
            toggleLopCN: () => {
                $('#title-cn').click(() => {
                    console.log(myWeb.Modals.data)
                        if (myWeb.Modals.toggleLopCN === true)
                            $('div#_cn-content').show();
                        else
                            $('div#_cn-content').hide();
                        myWeb.Modals.toggleLopCN = !myWeb.Modals.toggleLopCN;
                })
            }
        }

    }

    main = () => {
        $('div#_mh-content').hide();
        $('div#_cn-content').hide();
        myWeb.Controller.get_append_data();
        myWeb.Controller.toggleLopCN();
        myWeb.Controller.toggleLopMH();



    }
    window.onload = main();
})


















