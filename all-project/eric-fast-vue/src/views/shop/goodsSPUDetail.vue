
<template>
    <section>
        <div class="detail-top">
            <p class="title">商品组基本信息</p>
            <div class="pz-detailData">
                <ul>
                    <li>SPU：<span class="detail-SPU">{{this.$route.query.platformSpuId}}</span></li>
                    <li>商品名称：<span class="detail-name">{{this.spuDetail.name}}</span></li>
                    <li>商品分类：<span class="detail-style">{{this.spuDetail.name}}</span></li>
                </ul>
                <ul>
                    <li>商品描述：<span class="detail-style">{{this.spuDetail.simpleDesc}}</span></li>
                </ul>
            </div>
            <div class="pz-detailSKU">
                <div>
                    <ul>
                        <li>商品下的SKU列表：</li>
                    </ul>
                    <ul style="margin-left:-36px">
                        <li v-for="item in skuDetailInfo">{{item.platformSkuId}}</li>
                    </ul>
                </div>
                <div style="position: absolute;margin-top: 65px">
                    <ul>
                        <li>商品属性列表：</li>
                    </ul>
                    <ul style="margin-left:-36px">
                        <li v-for="items in this.spuSpecTypeInfo">{{items.specTypeName}}：
                            <span v-for="itemInfo in items.spuSpecInfo">{{itemInfo.specName}}&nbsp</span>
                        </li>
                    </ul>
                    <ul style="margin-left:-36px">

                    </ul>
                </div>
            </div>
        </div>
        <div class="detail-top">
            <p class="title">商品组图片信息</p>
            <div class="pz-detailData" style="height:400px">
                <ul>
                    <li>列表页图片：</li>
                </ul>
                <ul>
                    <li class="pz-list">
                        <a :href="this.spuDetail.listPicUrl" :download="this.spuDetail.listPicUrl" target="_blank"><img :src="this.spuDetail.listPicUrl" /></a>
                    </li>
                </ul>
                <ul>
                    <li>商品大图：</li>
                </ul>
                <ul>
                    <li class="pz-list" v-for="imgData in goodsImages">
                        <a :href="imgData.picUrl" :download="imgData.picUrl" target="_blank"><img :src="imgData.picUrl" /></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="detail-top">
            <p class="title">商品详情</p>
            <div class="pz-detailData" style="height:42px">
                <li>商品详情：<a class="detail-style" :href="this.spuDetail.detailHtml" :download="this.spuDetail.detailHtml" target="_blank">{{this.spuDetail.detailHtml}}</a></li>
            </div>
        </div>
    </section>
</template>

<script>
    export default {
        data() {
            return {
                spuDetail: {},
                skuDetailInfo: [],
                dataListLoading: false,
                spuSpecTypeInfo: [],
                items: [],
                itemInfo: [],
                goodsImages: []
            }
        },
        methods: {
            getsupplierDetail() {
                this.dataListLoading = true
                this.$http({
                    url: this.$http.adornUrl('shop/goods/querySpuDetail'),
                    method: 'post',
                    data: {
                        'platformSpuId': this.$route.query.platformSpuId,
                        'userChannelId': '001'
                    }
                }).then(({
                    data
                }) => {
                    if (data && data.code === 0) {
                        this.skuDetailInfo = data.spuDetail.skuDetailInfo;
                        this.spuSpecTypeInfo = data.spuDetail.spuSpecTypeInfo;
                        this.spuDetail = data.spuDetail;
                        this.goodsImages = data.spuDetail.goodsImages
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
            margin-left: 30px;
            height: 120px;
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
        overflow: auto;
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

    .pz-detailSKU {
        width: 100%;
        height: 300px;
        border: 1px solid #cccccc;
        border-top: none;
        box-sizing: border-box;
        clear: both;
        ul {
            float: left;
            font-size: 13px
        }
        li:first-child {
            margin-left: 0
        }
        li {
            list-style: none;
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

