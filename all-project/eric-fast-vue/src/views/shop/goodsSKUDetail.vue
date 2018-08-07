
<template>
    <section>
        <div class="detail-top">
            <p class="title">商品基本信息</p>
            <table class="pz-detailData">
                <tr>
                    <td>SKU</td>
                    <td>{{this.skuDetail.platformSkuId}}</td>
                    <td>SPU</td>
                    <td>{{this.skuDetail.platformSpuId}}</td>
                    <td>商品名称</td>
                    <td>{{this.skuDetail.name}}</td>
                </tr>
                <tr>
                    <td>商品状态</td>
                    <td>{{this.skuDetail.status}}</td>
                    <td>基准价格</td>
                    <td>{{this.skuDetail.benchmarkPrice}}元</td>
                    <td>商品售价</td>
                    <td>{{this.skuDetail.channelPrice}}元</td>
                </tr>
                <tr>
                    <td>规格文字信息</td>
                    <td colspan="5" style="text-align:left;padding-left:20px">{{this.skuDetail.displayString}}</td>
                </tr>
            </table>
        </div>
        <div class="detail-top">
            <p class="title">商品图片信息</p>
            <div class="pz-detailData" style="height:250px">
                <!-- <ul>
                        <li>退货原因：<span class="detail-SPU">{{address.province+address.city+address.area+address.street}}</span></li>
                        <li>退货原因详情描述：<span class="detail-name">{{this.order.handingReason}}</span></li>
                    </ul> -->
                <li>
                    <p class="pz-list">
                        <a :href="this.skuDetail.picUrl" :download="this.skuDetail.picUrl" target="_blank"><img :src="skuDetail.picUrl"/></a>
                    </p>
                    <!-- <p class="filename">{{item.fileName}}</p> -->
                </li>
            </div>
        </div>
    </section>
</template>

<script>
    export default {
        data() {
            return {
                skuDetail: {},
                dataListLoading: false,
            }
        },
        methods: {
            getsupplierDetail() {
                this.dataListLoading = true
                this.$http({
                    url: this.$http.adornUrl('shop/goods/querySkuDetail'),
                    method: 'post',
                    data: {
                        'platformSkuId': this.$route.query.platformSkuId,
                        'channelId': '001'
                    }
                }).then(({
                    data
                }) => {
                    if (data && data.code === 0) {
                        // this.goods = data.orderList.orderDetail.goods;
                        // this.address = data.orderList.orderDetail.address;
                        this.skuDetail = data.skuDetail;
                        var statusValues = {
                            "1": "已上架",
                            "2": "已下架",
                            "01": "上架待审核",
                            "02": "审核拒绝",
                        };
                        this.skuDetail.status = statusValues[this.skuDetail.status];

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

    .pz-list {
        img {
            width: 200px;
            margin-left: 30px
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

