//
//  SignUpVC.swift
//  justAnApplication
//
//  Created by Sean Shinil Lee on 5/5/22.
//

import UIKit

class SignUpVC: UIViewController {

    @IBOutlet weak var tf_fname: UITextField!
    @IBOutlet weak var tf_lname: UITextField!
    @IBOutlet weak var tf_email: UITextField!
    @IBOutlet weak var tf_pwd: UITextField!
    @IBOutlet weak var btn_signUp: UIButton!
    @IBOutlet weak var text_err: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setUpElements()
    }
    
    @IBAction func signUpTapped(_ sender: Any) {
        
    }
    
    func setUpElements(){
        text_err.alpha = 0 // hide error label
        
        // style elements
        Utilities.styleTextField(tf_fname)
        Utilities.styleTextField(tf_lname)
        Utilities.styleTextField(tf_email)
        Utilities.styleTextField(tf_pwd)
        Utilities.styleFilledButton(btn_signUp)
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
