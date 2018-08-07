<template>
    <div class="mod-user">
        <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
            <el-form-item label="SPU">
                <el-input v-model="dataForm.platformSpuId" placeholder="SPU"></el-input>
            </el-form-item>
            <el-form-item label="商品名称">
                <el-input v-model="dataForm.name" placeholder="商品名称"></el-input>
            </el-form-item>
            <el-form-item label="商品状态">
                <el-select v-model="dataForm.status">
                    <el-option label="全部" value="0"></el-option>
                    <el-option label="上架待审核" value="1"></el-option>
                    <el-option label="已上架" value="2"></el-option>
                    <el-option label="已下架" value="3"></el-option>
                    <el-option label="上架审核未通过" value="4"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="SKU">
                <el-input v-model="dataForm.platformSkuId" placeholder="SKU"></el-input>
            </el-form-item>
            <!-- <el-form-item label="融资日期">
                        <el-date-picker v-model="dataForm.billCreateDate" type="daterange" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" value-format="yyyy-MM-dd">
                        </el-date-picker>
                    </el-form-item> -->
            <el-form-item>
                <el-button @click="getDataList()">查询</el-button>
                <el-button @click="resetForm()">重置</el-button>
            </el-form-item>
        </el-form>
        <div class="detail-top" v-for="item in this.goodsList" v-loading="dataListLoading">
            <div class="title">
                <ul>
                    <li style="margin-left:0">SPU：<span class="detail-SPU">{{item.platformSpuId}}</span></li>
                    <li>商品名称：<span class="detail-name">{{item.name}}</span></li>
                    <li>商品分类：<span class="detail-style">{{item.simpleDesc}}</span></li>
                    <li @click="getSPUDetail(item)" class="getDetail" style="margin-left:370px">详情</li>
                </ul>
            </div>
            <div class="pz-detailData" v-for="items in item.goodsSkuDetail">
                <ul>
                    <li style="margin-left:10px">SKU：<span class="detail-SKU"></span>{{items.platformSkuId}}</li>
                    <li>基准价格：<span class="detail-name">{{items.benchmarkPrice}}</span>元</li>
                    <li>销售价格：<span class="detail-style">{{items.channelPrice}}</span>元</li>
                    <li>商品状态：<span class="detail-style" >{{formatPayType(items.status)}}</span></li>
                </ul>
                <ul style="line-height:28px">
                    <li style="margin-left:10px">{{items.displayString}}</li>
                </ul>
                <div style="position:absolute;left:800px;margin-top:-16px">
                    <el-button class="getDetail" @click="goUpdata(items)" type="text" size="small" v-if="items.status=='2'||items.status=='02'">商品上架</el-button>
					<el-button class="getDetail" @click="goDowndata(items)" type="text" size="small" v-if="items.status=='1'">商品下架</el-button>
                    <el-button class="getDetail" type="text" size="small" v-if="items.status=='01'" disabled="disabled">待审核</el-button>
                    <el-button @click="getSKUDetail(items)" class="getDetail">详情</el-button>
                </div>
            </div>
        </div>
        <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex" :page-sizes="[10, 20, 50, 100]" :page-size="pageSize" :total="totalPage" layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
    </div>
</template>

<script>
    //import AddOrUpdate from './listDetail'
    export default {
        data() {
            return {
                dataForm: {
                    platformSpuId: '',
                    platformSkuId: '',
                    name: '',
                    status: ''
                },
                goodsList: [],
                goodsImages: [],
                goodsSkuDetail: [],
                pageIndex: 1,
                pageSize: 5,
                totalPage: 0,
                dataListLoading: false,
            }
        },
        components: {
            //AddOrUpdate
        },
        activated() {
            this.getDataList()
        },
        methods: {
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true
                this.$http({
                    url: this.$http.adornUrl('shop/goods/queryGoodsList'),
                    method: 'post',
                    data: {
                        'pageNo': this.pageIndex,
                        'pageSize': this.pageSize,
                         'platformSpuId': this.dataForm.platformSpuId,
                         'platformSkuId': this.dataForm.platformSkuId,
                         'name': this.dataForm.name,
                         'status':this.dataForm.status,
                        'channelId': '001'
                    }
                }).then(({
                    data
                }) => {
                    if (data && data.code === 0) {
                        this.goodsList = data.goodsList
                        this.totalPage = Number(data.totalNum)
                    } else {
                        this.dataList = []
                        this.totalPage = 0
                    }
                    this.dataListLoading = false
                })
            },
            // dataFormat(status){
            //     let temp={1:'已上架',2:'已下架',01:'上架待审核',02:'审核拒绝'}
            //     return temp[status];
            // },
            formatPayType(payType) {     //结单类型
		      let tmp = {'1':'已上架','2':'已下架','01':'上架待审核','02':'审核拒绝'};
		      return tmp[payType];
	        },
            // 每页数
            sizeChangeHandle(val) {
                this.pageSize = val
                this.pageIndex = 1
                this.getDataList()
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val
                this.getDataList()
            },
            // 商品上架
            goUpdata(id) {
                this.$confirm(`确定要上架该商品吗?`, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    //type: 'warning'
                }).then(() => {
                    this.$http({
                        url: this.$http.adornUrl('shop/goods/goodsUpOrDown'),
                        method: 'post',
                        data: {
                        'platformSpuId': id.platformSpuId,
                        'platformSkuId': id.platformSkuId,
                        'type': 41,
                        'channelId': '001'
                    }
                    }).then(({
                        data
                    }) => {
                        if (data && data.code === 0) {
                            this.$message({
                                message: '操作成功',
                                type: 'success',
                                duration: 1500,
                                onClose: () => {
                                    this.getDataList()
                                }
                            })
                        } else {
                            this.$message.error(data.msg)
                        }
                    })
                }).catch(() => {})
            },
            // 商品下架
            goDowndata(id) {
                this.$confirm(`确定要下架该商品吗?`, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    //type: 'warning'
                }).then(() => {
                    this.$http({
                        url: this.$http.adornUrl('shop/goods/goodsUpOrDown'),
                        method: 'post',
                        data: {
                        'platformSpuId': id.platformSpuId,
                        'platformSkuId': id.platformSkuId,
                        'type': 42,
                        'channelId': '001'
                    }
                    }).then(({
                        data
                    }) => {
                        if (data && data.code === 0) {
                            this.$message({
                                message: '操作成功',
                                type: 'success',
                                duration: 1500,
                                onClose: () => {
                                    this.getDataList()
                                }
                            })
                        } else {
                            this.$message.error(data.msg)
                        }
                    })
                }).catch(() => {})
            },
            //SPU详情
            getSPUDetail(id) {
                this.$router.push({
                    path:'/shop-goodsSPUDetail',
                    query:{
                      platformSpuId:id.platformSpuId
                    }
                });
            },
            //详情
            getSKUDetail(id) {
                this.$router.push({
                    path: '/shop-goodsSKUDetail',
                    query: {
                        platformSkuId: id.platformSkuId
                    }
                });
            },
            //重置
            resetForm() {
                this.dataForm = {},
                    this.getDataList();
            },
        }
    }
</script>

<style lang="scss">
    .detail-top {
        margin-bottom: 40px;
        box-sizing: border-box;
        .title {
            text-align: center;
            background: rgba(242, 242, 242, 1);
            height: 40px;
            line-height: 40px;
        }
    }

    .detail-top li {
        list-style: none;
        float: left;
        margin-left: 100px
    }

    .getDetail {
        margin-left: 5px;
        line-height: 27px;
        border: 1px solid #a29c9c;
        margin-top: 7px;
        padding: 0 16px;
        border-radius: 4px;
        background: rgba(255, 255, 255, 1)
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
            margin-left: 80px;
            margin-top: 11px
        }
    }
</style>

