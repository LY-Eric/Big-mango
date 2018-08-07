
<template>
    <section>
        <div class="detail-top">
            <p class="title">退款基本信息</p>
            <table class="pz-detailData">
                <tr>
                    <td>退款单流水号</td>
                    <td>{{this.order.orderReturnId}}</td>
                    <td>订单号</td>
                    <td @click="godetail">{{this.order.orderId}}</td>
                    <td>申请人</td>
                    <td>{{this.order.returnUserName}}</td>
                </tr>
                <tr>
                    <td>申请人联系电话</td>
                    <td>{{this.address.telphone}}</td>
                    <td>发货包裹号</td>
                    <td>{{this.order.orderPackageId}}</td>
                    <td>申请退款时间</td>
                    <td>{{this.order.returnSubmitTime}}</td>
                </tr>
                <tr>
                    <td>退款单状态</td>
                    <td>{{this.order.returnOrderStatus}}</td>
                    <td>退货类型</td>
                    <td>{{this.order.handingType}}</td>
                    <td>实付金额</td>
                    <td>{{this.order.oughtPayAmount}}元</td>
                </tr>
                <tr>
                    <td>退款金额</td>
                    <td>{{this.order.returnAmount}}元</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <div class="detail-top">
            <p class="title">退款原因详情</p>
            <div class="pz-detailData">
                <ul>
                    <li>退货原因：<span class="detail-SPU">{{address.province+address.city+address.area+address.street}}</span></li>
                    <li>退货原因详情描述：<span class="detail-name">{{this.order.handingReason}}</span></li>
                </ul>
                <!-- <li v-for="item in pmTotleExtend">
                        <p class="pz-list">
                            <a :href="item.fileAddress" :download="item.fileName"><img src="../../styles/img/zip.jpg" height="100%" width="100%" /></a>
                        </p>
                        <p class="filename">{{item.fileName}}</p>
                    </li> -->
            </div>
        </div>
        <div class="detail-top">
            <p class="title">退款单商品明细</p>
            <div class="pz-detailData" v-for="item in goods">
                <ul>
                    <li>申请退款SKU：<span class="detail-SPU">{{item.platformSkuId}}</span></li>
                    <li>申请退款SKU件数：<span class="detail-name">{{item.goodsNum}}</span></li>
                    <li>SKU单价<span class="detail-style">{{item.goodsPrice}}元</span></li>
                </ul>
                <ul>
                    <li>实付金额小计：<span class="detail-SPU">{{item.payAmount}}元</span></li>
                    <li>退款金额：<span class="detail-name">{{item.refundAmount}}元</span></li>
                </ul>
            </div>
        </div>
    </section>
</template>

<script>
    export default {
        data() {
            return {
                address: {},
                goods: [],
                order: {},
                dataListLoading: false,
            }
        },
        methods: {
            getsupplierDetail() {
                this.dataListLoading = true
                this.$http({
                    url: this.$http.adornUrl('shop/order/queryReturnOrderDetail'),
                    method: 'post',
                    data: {
                        'orderReturnId': this.$route.query.orderReturnId,
                        'channelId': '001'
                    }
                }).then(({
                    data
                }) => {
                    if (data && data.code === 0) {
                        this.goods = data.orderList.orderDetail.goods;
                        this.address = data.orderList.orderDetail.address;
                        this.order = data.orderList.orderDetail.orderReturn;
                        var fileTypeValues = {
                            "1": "待确认",
                            "2": "供应商拒绝",
                            "3": "待退货",
                            "4": "待确认收货",
                            "5": "待退款",
                            "6": "退款成功",
                        };
                        this.order.returnOrderStatus = fileTypeValues[this.order.returnOrderStatus];
                        var handingTypeValues = {
                            "1": "退款退货",
                            "2": "仅退款",
                        };
                        this.order.handingType = handingTypeValues[this.order.handingType];

                    } else {
                        this.dataList = []
                        this.totalPage = 0
                    }
                    this.dataListLoading = false
                })
            },
            godetail() {
                this.$router.push({
                    path: '/order-listDetail',
                    query: {
                        orderId: this.order.orderId
                    }
                });

            },
        },
        mounted() {
            this.getsupplierDetail();
        }

    }
</script>

<style lang="scss">
    .detail-top {
        margin-bottom: 40px;
        box-sizing: border-box;
        .title {
            text-align: center;
            background: rgba(204, 204, 204, 1);
            height: 40px;
            line-height: 40px;
            margin-bottom: 0px;
        }
        table tr,
        table td {
            border: 1px solid #cccccc;
        }
        table td {
            width: 16.66%;
            height: 35px;
        }
        table {
            width: 100%;
            text-align: center;
            border-collapse: collapse;
        }
    }

    .pz-img {
        width: 100%;
        height: 150px;
        border: 1px solid #cccccc;
        box-sizing: border-box;
        overflow: hidden;
        li {
            list-style: none;
            text-align: center;
            width: 130px;
            overflow: hidden;
            float: left;
        }
    }

    .goback {
        position: absolute;
        right: 0;
        top: 20px;
    }

    .pz-detailData {
        width: 100%;
        height: 80px;
        border: 1px solid #cccccc;
        box-sizing: border-box;
        overflow: hidden;
        ul {
            clear: both;
            font-size: 13px
        }
        li:first-child {
            margin-left: 0
        }
        li {
            list-style: none;
            float: left;
            margin-left: 60px;
            margin-top: 11px
        }
    }

    .grin {
        color: #cccccc
    }

    .warmTip {
        border: 1px solid #ccc;
        margin: 0;
        border-top: none;
        padding: 10px 35px;
    }
</style>

