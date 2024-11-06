import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';
import Hosts from  '@/pages/Hosts.vue';
import HostDetail from  '@/pages/HostDetail.vue';
import Guests from  '@/pages/Guests.vue';
import GuestDetail from  '@/pages/GuestDetail.vue';
import Listings from  '@/pages/Listings.vue';
import ListingDetail from  '@/pages/ListingDetail.vue';
import Bookings from  '@/pages/Bookings.vue';
import BookingDetail from  '@/pages/BookingDetail.vue';
import Amenitys from  '@/pages/Amenitys.vue';
import AmenityDetail from  '@/pages/AmenityDetail.vue';
import Reviews from  '@/pages/Reviews.vue';
import ReviewDetail from  '@/pages/ReviewDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Photos from  '@/pages/Photos.vue';
import PhotoDetail from  '@/pages/PhotoDetail.vue';
import Messages from  '@/pages/Messages.vue';
import MessageDetail from  '@/pages/MessageDetail.vue';
import Wishlists from  '@/pages/Wishlists.vue';
import WishlistDetail from  '@/pages/WishlistDetail.vue';
import WishlistItems from  '@/pages/WishlistItems.vue';
import WishlistItemDetail from  '@/pages/WishlistItemDetail.vue';
import CancellationPolicys from  '@/pages/CancellationPolicys.vue';
import CancellationPolicyDetail from  '@/pages/CancellationPolicyDetail.vue';
import Discounts from  '@/pages/Discounts.vue';
import DiscountDetail from  '@/pages/DiscountDetail.vue';
import Locations from  '@/pages/Locations.vue';
import LocationDetail from  '@/pages/LocationDetail.vue';
import ContactSupports from  '@/pages/ContactSupports.vue';
import ContactSupportDetail from  '@/pages/ContactSupportDetail.vue';
import Responses from  '@/pages/Responses.vue';
import ResponseDetail from  '@/pages/ResponseDetail.vue';
import Admins from  '@/pages/Admins.vue';
import AdminDetail from  '@/pages/AdminDetail.vue';
import Coupons from  '@/pages/Coupons.vue';
import CouponDetail from  '@/pages/CouponDetail.vue';
import CleaningFees from  '@/pages/CleaningFees.vue';
import CleaningFeeDetail from  '@/pages/CleaningFeeDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/users',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/hosts',
		name: 'Hosts',
		layout: DefaultLayout,
		component: Hosts,
	},
	{
	    path: '/host/:hostId', 
	    name: 'HostDetail',
		layout: DefaultLayout,
	    component: HostDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/guests',
		name: 'Guests',
		layout: DefaultLayout,
		component: Guests,
	},
	{
	    path: '/guest/:guestId', 
	    name: 'GuestDetail',
		layout: DefaultLayout,
	    component: GuestDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/listings',
		name: 'Listings',
		layout: DefaultLayout,
		component: Listings,
	},
	{
	    path: '/listing/:listingId', 
	    name: 'ListingDetail',
		layout: DefaultLayout,
	    component: ListingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bookings',
		name: 'Bookings',
		layout: DefaultLayout,
		component: Bookings,
	},
	{
	    path: '/booking/:bookingId', 
	    name: 'BookingDetail',
		layout: DefaultLayout,
	    component: BookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/amenitys',
		name: 'Amenitys',
		layout: DefaultLayout,
		component: Amenitys,
	},
	{
	    path: '/amenity/:amenityId', 
	    name: 'AmenityDetail',
		layout: DefaultLayout,
	    component: AmenityDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reviews',
		name: 'Reviews',
		layout: DefaultLayout,
		component: Reviews,
	},
	{
	    path: '/review/:reviewId', 
	    name: 'ReviewDetail',
		layout: DefaultLayout,
	    component: ReviewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/photos',
		name: 'Photos',
		layout: DefaultLayout,
		component: Photos,
	},
	{
	    path: '/photo/:photoId', 
	    name: 'PhotoDetail',
		layout: DefaultLayout,
	    component: PhotoDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/messages',
		name: 'Messages',
		layout: DefaultLayout,
		component: Messages,
	},
	{
	    path: '/message/:messageId', 
	    name: 'MessageDetail',
		layout: DefaultLayout,
	    component: MessageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlists',
		name: 'Wishlists',
		layout: DefaultLayout,
		component: Wishlists,
	},
	{
	    path: '/wishlist/:wishlistId', 
	    name: 'WishlistDetail',
		layout: DefaultLayout,
	    component: WishlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlistItems',
		name: 'WishlistItems',
		layout: DefaultLayout,
		component: WishlistItems,
	},
	{
	    path: '/wishlistItem/:wishlistItemId', 
	    name: 'WishlistItemDetail',
		layout: DefaultLayout,
	    component: WishlistItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/cancellationPolicys',
		name: 'CancellationPolicys',
		layout: DefaultLayout,
		component: CancellationPolicys,
	},
	{
	    path: '/cancellationPolicy/:cancellationPolicyId', 
	    name: 'CancellationPolicyDetail',
		layout: DefaultLayout,
	    component: CancellationPolicyDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/discounts',
		name: 'Discounts',
		layout: DefaultLayout,
		component: Discounts,
	},
	{
	    path: '/discount/:discountId', 
	    name: 'DiscountDetail',
		layout: DefaultLayout,
	    component: DiscountDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/locations',
		name: 'Locations',
		layout: DefaultLayout,
		component: Locations,
	},
	{
	    path: '/location/:locationId', 
	    name: 'LocationDetail',
		layout: DefaultLayout,
	    component: LocationDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/contactSupports',
		name: 'ContactSupports',
		layout: DefaultLayout,
		component: ContactSupports,
	},
	{
	    path: '/contactSupport/:contactSupportId', 
	    name: 'ContactSupportDetail',
		layout: DefaultLayout,
	    component: ContactSupportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/responses',
		name: 'Responses',
		layout: DefaultLayout,
		component: Responses,
	},
	{
	    path: '/response/:responseId', 
	    name: 'ResponseDetail',
		layout: DefaultLayout,
	    component: ResponseDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/admins',
		name: 'Admins',
		layout: DefaultLayout,
		component: Admins,
	},
	{
	    path: '/admin/:adminId', 
	    name: 'AdminDetail',
		layout: DefaultLayout,
	    component: AdminDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/coupons',
		name: 'Coupons',
		layout: DefaultLayout,
		component: Coupons,
	},
	{
	    path: '/coupon/:couponId', 
	    name: 'CouponDetail',
		layout: DefaultLayout,
	    component: CouponDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/cleaningFees',
		name: 'CleaningFees',
		layout: DefaultLayout,
		component: CleaningFees,
	},
	{
	    path: '/cleaningFee/:cleaningFeeId', 
	    name: 'CleaningFeeDetail',
		layout: DefaultLayout,
	    component: CleaningFeeDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
