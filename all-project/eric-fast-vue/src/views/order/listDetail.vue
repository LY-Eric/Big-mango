
<template>
	<section>
		<div class="detail-top">
			<p class="title">订单基本信息</p>
			<div class="pz-detailData">
				<ul>
					<li>订单号：<span class="detail-SPU">{{this.order.orderId}}</span></li>
					<li>用户下单时间：<span class="detail-name">{{this.order.createdTime}}</span></li>
					<li>订单状态：<span class="detail-style">{{this.order.orderStatus}}</span></li>
					<li>买家用户名：<span class="detail-style">{{this.order.userId}}</span></li><br>
				</ul>
				<li style="margin-left:40px">用户支付时间：<span class="detail-style">{{this.order.paymentTime}}</span></li>
			</div>
		</div>
		<div class="detail-top">
			<p class="title">费用明细</p>
			<div class="pz-detailData">
				<ul>
					<li>订单总金额：<span class="detail-SPU">{{this.order.orderAmountTotal}}</span>元</li>
					<li>优惠金额：<span class="detail-name">0.00</span>元</li>
					<li>运费金额：<span class="detail-style">{{this.order.logisticsFee}}</span>元</li>
					<li>应付金额：<span class="detail-style">{{this.order.oughtPayAmount}}</span>元</li>
				</ul>
			</div>
		</div>
		<div class="detail-top">
			<p class="title">付款明细</p>
			<div class="pz-detailData">
				<ul>
					<li>实付金额：<span class="detail-SPU">{{this.order.actuallyPayAmount}}</span>元</li>
					<li class="grin">(现金支付：<span class="detail-name">{{this.paymentComposition.cash}}</span>元</li>
					<li class="grin">优惠券抵扣金额：<span class="detail-style">{{this.paymentComposition.coupon}}</span>元</li>
					<li class="grin">积分抵扣金额：<span class="detail-style">{{this.paymentComposition.point}}</span>元)</li>
				</ul>
			</div>
		</div>
		<div class="detail-top">
			<p class="title">订单收货人信息</p>
			<div class="pz-detailData">
				<ul>
					<li>收件人姓名：<span class="detail-SPU">{{this.address.realName}}</span></li>
					<li>收件人手机号：<span class="detail-name">{{this.address.telphone}}</span></li>
					<li>收件人邮编：<span class="detail-style">{{this.address.zip}}</span></li><br>
				</ul>
				<li style="margin-left:39px">收件人详细地址：<span class="detail-style">{{this.order.orderAddress}}</span></li>
			</div>
		</div>
		<div class="detail-top">
			<p class="title">商品清单</p>
			<el-table :data="tableData" border style="width: 100%">
				<el-table-column type="index" width="100" label="序号" align="center">
				</el-table-column>
				<el-table-column property="platformSkuId" label="SKU" width="200" align="center">
				</el-table-column>
				<el-table-column property="goodsName" label="商品名称" width="212" align="center">
				</el-table-column>
				<el-table-column property="goodsNum" label="购买数量" width="150" align="center">
				</el-table-column>
				<el-table-column property="goodsPrice" label="商品单价（元）" width="150" align="center">
				</el-table-column>
				<el-table-column property="goodsAmountSum" label="商品小计（元）" width="150" align="center">
				</el-table-column>
			</el-table>
		</div>
		<!-- <div class="detail-top">
			<p class="title">物流信息</p>
			<div class="pz-detailData">
				<ul>
					<li>包裹号：<span class="detail-SPU">1000000000001</span></li>
				</ul>
			</div>
			<p class="warmTip">由于商品在不同的库房发货，故将订单拆分成不同的包裹进行发货</p>
		</div> -->
	</section>
</template>

<script>
	export default {
		data() {
			return {
				tableData: [],
				order:{},
				address:{},
				paymentComposition:{},
				dataListLoading: false,
			}
		},
		methods: {
			getsupplierDetail() {
				this.dataListLoading = true
				this.$http({
					url: this.$http.adornUrl('shop/order/queryOrderDetail'),
					method: 'post',
					data: {
						'orderId': this.$route.query.orderId,
						'channelId': '001'
					}
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						this.address = data.orderList.orderDetail.address;
						this.tableData = data.orderList.orderDetail.goods;
						this.order = data.orderList.orderDetail.order;
						this.paymentComposition = data.orderList.orderDetail.paymentComposition;
						var fileTypeValues = {
							"0": "不可见",
							"1": "待付款",
							"2": "未付款已取消",
							"3": "到期未付款系统取消",
							"4": "已付款取消",
							"5": "待发货",
							"6": "供应商取消",
							"7": "待收货",
							"8": "已退款",
							"9": "交易成功",
						};
						this.order.orderStatus = fileTypeValues[this.order.orderStatus];
					} else {
						this.dataList = []
						this.totalPage = 0
					}
					this.dataListLoading = false
				})
			},
			goBack() {
				this.$router.go(-1)
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

