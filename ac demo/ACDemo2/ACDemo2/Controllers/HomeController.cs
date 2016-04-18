using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Mail;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace ACDemo2.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult SignUp()
        {

            return View();

        }


        public ActionResult LoggedIn()
        {

            return View();

        }

        public ActionResult LogOut()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Home");
        }

        [HttpPost]
        public ActionResult SignUp(UserInfo user)
        {
            
            try
            {
                if (ModelState.IsValid)
                {
                    using (var db = new ACheckDemoEntities())
                    {
                        MailAddress addr = new MailAddress(user.emailId);
                        user.username = addr.User;
                        db.UserInfoes.Add(user);
                        db.SaveChanges();
                        ViewBag.Message = "Sign Up Complete";

                        return View("Success");
                    }
                }
                else
                {
                    ModelState.AddModelError("", "Data is not correct");
                }
            }

            catch (Exception e)
            {
                ModelState.AddModelError("", "This e-mail Id is already registered.");
            }
            return View();
        }

        public ActionResult Login()
        {
            ViewBag.Message = "Your Login page.";

            return View();
        }

        [HttpPost]
        public ActionResult Login(string username, string passwordHash)
        {
            ViewBag.Message = "Your Login page.";
            using (var db = new ACheckDemoEntities())
            {
                 
                var user = db.UserInfoes.FirstOrDefault(u => u.username == username && u.passwordHash == passwordHash);
                if (user != null)
                {
                    // Set a authorization cookie for the logged in user.
                    FormsAuthentication.SetAuthCookie(user.emailId, false);
                    
                    ViewBag.Message = "Welcome,"+ user.emailId;

                    return RedirectToAction("LoggedIn", "Home");
                } else
                {
                    ViewBag.Message = "Incorrect username or password";
                }
                
            }

            ViewBag.Message = "Your Login Failed. Try Again.";
            return View();
        }
    }
}