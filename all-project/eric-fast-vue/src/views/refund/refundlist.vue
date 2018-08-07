<template>
    <div class="mod-user">
        <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
            <el-form-item label="退款单号">
                <el-input v-model="dataForm.orderReturnId" placeholder="退款单号"></el-input>
            </el-form-item>
            <el-form-item label="退款单状态">
                <el-select v-model="dataForm.orderStatus">
                    <el-option label="全部" value=""></el-option>
                    <el-option label="待确认" value="1"></el-option>
                    <el-option label="供应商拒绝" value="2"></el-option>
                    <el-option label="待退货" value="3"></el-option>
                    <el-option label="待确认收货" value="4"></el-option>
                    <el-option label="待退款" value="5"></el-option>
                    <el-option label="退款成功" value="6"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="订单号">
                <el-input v-model="dataForm.orderId" placeholder="订单号"></el-input>
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
            <el-table-column prop="returnSubmitTime" header-align="center" align="center" label="申请退款时间">
            </el-table-column>
            <el-table-column prop="orderReturnId" header-align="center" align="center" label="退款单号">
            </el-table-column>
            <el-table-column prop="returnOrderStatus" header-align="center" align="center" label="退款状态">
                <template slot-scope="scope">
                    <el-tag v-if="scope.row.returnOrderStatus === '1'" size="small" type="danger">待确认</el-tag>
                    <el-tag v-if="scope.row.returnOrderStatus === '2'" size="small" type="danger">供应商拒绝</el-tag>
                    <el-tag v-if="scope.row.returnOrderStatus === '3'" size="small" type="danger">待退货</el-tag>
                    <el-tag v-if="scope.row.returnOrderStatus === '4'" size="small" type="danger">待确认收货</el-tag>
                    <el-tag v-if="scope.row.returnOrderStatus === '5'" size="small" type="danger">待退款</el-tag>
                    <el-tag v-if="scope.row.returnOrderStatus === '6'" size="small" type="danger">退款成功</el-tag>
                </template>
           </el-table-column>
      <el-table-column prop="orderId" header-align="center" align="center" label="关联订单号">
      </el-table-column>
      <el-table-column prop="oughtPayAmount" header-align="center" align="center" label="订单金额（元）">
      </el-table-column>
      <el-table-column prop="returnAmount" header-align="center" align="center" label="申请退款金额（元）">
      </el-table-column>
      <el-table-column label="操作" width="60" align="center">
		<template slot-scope="scope">
		  <el-button @click="godetail(scope.row)" type="text" size="small">详情</el-button>
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
    export default {
        data() {
            return {
                dataForm: {
                    orderReturnId: '',
                    orderStatus: '',
                    orderId: '',
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
                    url: this.$http.adornUrl('shop/order/queryReturnOrderList'),
                    method: 'post',
                    data: {
                        'pageNo': this.pageIndex,
                        'pageSize': this.pageSize,
                        'orderReturnId': this.dataForm.orderReturnId,
                        'orderStatus': this.dataForm.orderStatus,
                        'orderId': this.dataForm.orderId,
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
                    path:'/refund-refundlistDetail',
                    query:{
                      orderReturnId:id.orderReturnId
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

