//
//  ViewController.swift
//  justAnApplication
//
//  Created by Sean Shinil Lee on 5/5/22.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var btn_login: UIButton!
    @IBOutlet weak var btn_signUp: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setUpElements()
    }

    func setUpElements(){
    
        Utilities.styleFilledButton(btn_signUp)
        Utilities.styleHollowButton(btn_login)
    }

}

