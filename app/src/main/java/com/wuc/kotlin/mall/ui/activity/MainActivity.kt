package com.wuc.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.wuc.kotlin.base.common.AppManager
import com.wuc.kotlin.base.ui.activity.BaseActivity
import com.wuc.kotlin.base.utils.AppPrefsUtils
import com.wuc.kotlin.goods.common.GoodsConstant
import com.wuc.kotlin.goods.event.UpdateCartSizeEvent
import com.wuc.kotlin.goods.ui.fragment.CartFragment
import com.wuc.kotlin.goods.ui.fragment.CategoryFragment
import com.wuc.kotlin.mall.R
import com.wuc.kotlin.mall.ui.fragment.HomeFragment
import com.wuc.kotlin.mall.ui.fragment.MeFragment
import com.wuc.kotlin.message.ui.fragment.MessageFragment
import com.wuc.kotlin.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : BaseActivity() {

    private var pressTime: Long = 0
    //Fragment栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mCategoryFragment: CategoryFragment by lazy { CategoryFragment() }
    //购物车Fragment
    private val mCartFragment: CartFragment by lazy { CartFragment() }
    //消息Fragment
    private val mMsgFragment: MessageFragment by lazy { MessageFragment() }
    //"我的"Fragment
    private val mMeFragment: MeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        initBottomNav()
        changeFragment(0)
        initObserve()
        loadCartSize()
    }

    /*
    初始化栈管理
     */
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)
        manager.add(R.id.mContainer, mCategoryFragment)
        manager.add(R.id.mContainer, mCartFragment)
        manager.add(R.id.mContainer, mMsgFragment)
        manager.add(R.id.mContainer, mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    /*
    初始化底部导航切换事件
     */
    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
        mBottomNavBar.checkMsgBadge(false)
    }

    /*
    切换Tab，切换对应的Fragment
     */
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

    /*
        监听购物车数量变化事件
     */
    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)
        Bus.observe<MessageBadgeEvent>()
                .subscribe {
                    mBottomNavBar.checkMsgBadge(true)
                }.registerInBus(this)
    }

    /*
        加载购物车数量
     */
    private fun loadCartSize() {
        mBottomNavBar.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    /*
    重写back事件，双击退出
     */
    override fun onBackPressed() {
        if (System.currentTimeMillis() - pressTime > 2000) {
            pressTime = System.currentTimeMillis()
            toast("再按一次退出程序")
        } else {
            AppManager.instance.exitApp(this)
        }
    }
}
