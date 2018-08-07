<template>
    <div class="mod-user">
        <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
            <el-form-item label="订单号">
                <el-input v-model="dataForm.orderId" placeholder="订单号"></el-input>
            </el-form-item>
            <el-form-item label="订单状态">
                <el-select v-model="dataForm.orderStatus">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="待付款" value="1"></el-option>
                    <el-option label="待发货" value="5"></el-option>
                    <el-option label="待收货" value="7"></el-option>
                    <el-option label="已退款" value="8"></el-option>
                    <el-option label="交易成功" value="9"></el-option>
                    <el-option label="交易取消" value="10"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="SKU">
                <el-input v-model="dataForm.sku" placeholder="SKU"></el-input>
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
        <el-table :data="dataList" border v-loading="dataListLoading" style="width: 100%;">
            <el-table-column type="index" label="序号" width="60" align="center">
            </el-table-column>
            <el-table-column prop="createdTime" header-align="center" align="center" label="下单时间">
            </el-table-column>
            <el-table-column prop="orderId" header-align="center" align="center" label="订单号">
            </el-table-column>
            <el-table-column prop="orderStatus" header-align="center" align="center" label="订单状态">
                <template slot-scope="scope">
                    <el-tag v-if="scope.row.orderStatus === '0'" size="small" type="danger">不可见</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '1'" size="small" type="danger">待付款</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '2'" size="small" type="danger">交易关闭</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '3'" size="small" type="danger">交易关闭</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '4'" size="small" type="danger">交易关闭</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '5'" size="small" type="danger">待发货</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '6'" size="small" type="danger">交易关闭</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '7'" size="small" type="danger">待收货</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '8'" size="small" type="danger">已退款</el-tag>
                    <el-tag v-if="scope.row.orderStatus === '9'" size="small" type="danger">交易成功</el-tag>
                </template>
           </el-table-column>
      <el-table-column prop="goodsAmountTotal" header-align="center" align="center" label="订单金额（元）">
      </el-table-column>
      <el-table-column prop="orderAmountTotal" header-align="center" align="center" label="订单实付金额（元）">
      </el-table-column>
      <el-table-column label="操作" width="60" align="center">
<template slot-scope="scope">
    <el-button @click="godetail(scope.row)" type="text" size="small">
        详情</el-button>
</template>
	  </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
  </div>
</template>

<script>
    //import AddOrUpdate from './listDetail'
    export default {
        data() {
            return {
                dataForm: {
                    orderId: '',
                    orderStatus: '',
                    sku: '',
                    channelUserId:''
                },
                dataList: [],
                pageIndex: 1,
                pageSize: 10,
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
                    url: this.$http.adornUrl('shop/order/queryOrderList'),
                    method: 'post',
                    data: {
                        'pageNo': this.pageIndex,
                        'pageSize': this.pageSize,
                        'orderId': this.dataForm.orderId,
                        'orderStatus': this.dataForm.orderStatus,
                        'sku': this.dataForm.sku,
                        'channelId': '001'
                    }
                }).then(({
                    data
                }) => {
                    if (data && data.code === 0) {
                        this.dataList = data.orderList.tList
                        this.totalPage = data.orderList.totalNum
                    } else {
                        this.dataList = []
                        this.totalPage = 0
                    }
                    this.dataListLoading = false
                })
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
            //详情
            godetail(id) {
                this.$router.push({
                    path:'/order-listDetail',
                    query:{
                      orderId:id.orderId
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

